//边沿检测: 通过D触发器, 给出信号由1跳0的时刻
module FallingEdge(
	input wire d, clk,
	output wire D_falling_edge
);
	reg q;//前一时刻的值
	always @ (posedge clk) begin //D type FlipFlop
            q <= d;
	end
	assign D_falling_edge = (q & ~d);	//信号下边沿
endmodule

//三态门, 
module ThreeStateGate
#(	parameter width = 16 ) (
	inout wire  [ width - 1 : 0 ] 	bio,
	input wire  [ width - 1 : 0 ] 	din,
	input wire 						en,	//en是使能信号, 用于开关三态门
	output wire [ width - 1 : 0 ] 	dout
);
	assign bio = en ? din : {width{1'bz}};
	assign dout = bio;
endmodule

//真双口RAM
module DualPortRAM
#(	parameter addr_width = 12,	//地址线宽度
	parameter data_width = 16	//数据线宽度
)(
	input wire [ addr_width - 1 : 0 ] 	data_a, data_b,
	input wire [ data_width - 1 : 0 ]	addr_a, addr_b,
	input wire							wr_a, wr_b,
	input wire							rd_a, rd_b,
	input wire							clk,
	output reg [ data_width - 1 : 0] 	q_a, q_b
);
	localparam depth = (2**address_width);

	reg [ data_width - 1 : 0 ] ram [ depth - 1 : 0]; //declare ram
	
	//Port A
	always @ (posedge clk) begin
		if(wr_a) begin	//write
			ram[addr_a] <= data_a;	q_a <= data_a;
		end
		if(rd_a) begin	//read
			q_a <= ram[addr_a];
		end
	end
	
	//Port B
	always @ (posedge clk) begin
		if(wr_b) begin	//write
			ram[addr_b] <= data_b; q_b <= data_b;
		end
		if(rd_b) begin	//read
			q_b <= ram[addr_b];
		end
	end
endmodule


//GPMC to 16-Bit (AD)multiplexed Memory (assynchronous)
//External device = FPGA
module gpmc_fpga(
	input wire sys_clk,

	input wire [11:0] A,	//地址线, 最多27位
	inout wire [15:0] D,	//数据线, 16bit
	input wire CSn,			//片选		
	input wire ADVn,		//地址有效信号, 用于锁存地址
	input wire OEn,			//输出使能
	input wire WEn,			//写入使能
	input wire BE0n_CLE,	//字节有效~
	input wire BE1n,		//字节有效~
	input wire WPn,			//写入保护~
	output wire WAIT		//等待信号~
);

	//分别检测ADVn, WEn, OEn的下降沿
	wire ADVn_negedge, WEn_negedge, OEn_negedge;
	DownTrig uut1( .d(ADVn), .clk(sys_clk), .D_falling_edge(ADVn_negedge) );
	DownTrig uut2( .d(WEn), .clk(sys_clk), .D_falling_edge(WEn_negedge) );
	DownTrig uut3( .d(OEn), .clk(sys_clk), .D_falling_edge(OEn_negedge) );
	
	reg [11:0] local_A;
	
	wire [15:0] din, dout;
	ThreeStateGate inst_data_bus #(	.width(16) ) (
		.bio(D),
		.din(din),
		.en((~CSn) & (~OEn)),	//en是使能信号, 用于开关三态门
		.dout(dout)
	);
	
	always @ (posedge sys_clk) begin
		if((~CSn) & ADVn_negedge) begin
				local_A <= A;	//锁存地址
		end
	end
	
	DualPortRAM
	#(	.addr_width(12),	//地址线宽度
		.data_width(16)		//数据线宽度
	) inst_DualPortRAM_1 (
		.clk(sys_clk),
		.data_a(local_A),				.data_b(16'b0),
		.addr_a(dout),					.addr_b(12'b0),
		.wr_a((~CSn) & WEn_negedge),	.wr_b(1'b0),
		.rd_a((~CSn) & OEn_negedge),	.rd_b(1'b0),
		.q_a(din),						.q_b()
	);

	assign WAIT = 1'b1;
endmodule