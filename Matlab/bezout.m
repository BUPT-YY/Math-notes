%一元多项式环中用扩展Euclid算法求Bezout定理的系数
% u(x)f(x)+v(x)g(x) = gcd(f,g)


function [u, v, gcd] = bezout(f, g)
    err = 0.001;
    index = min(find(f~=0,1)); f = f(index:end);
    index = min(find(g~=0,1)); g = g(index:end);

    um = [1]; u = [0];
    vm = [0]; v = [1];
    if(length(f) < length(g))
        p = f; pm = g;
    else
        p = g; pm = f;
    end
    

    [q,pp] = deconv(pm, p); %一元多项式带余除法 g = qf + r; [q,r] = deconv(g,f)
    while(norm(pp)>err)
        up = subtract(um, conv(u,q));
        up = up(min(find(up~=0,1)):end);
        %up = um - conv(u,q);       %长度可能不同, 直接相减有bug
        vp = subtract(vm, conv(v,q));
        vp = vp(min(find(vp~=0,1)):end);
        %vp = vm - conv(v,q);
        um = u; u = up;
        vm = v; v = vp;
        pm = p; p = pp(min(find(pp~=0,1)):end);
    
        gcd = p;
        [q,pp] = deconv(pm, p);
    end
    
    if(length(f) < length(g))
        temp = u; u = v; v = temp;
    end
    
    
end

function [result] = subtract(a,b)
    m = length(a); n = length(b);
    if(m == n)
        result = a-b;
    elseif(m < n)
        result = -b;
        for i=1:m
            result(n-(m-i)) = result(n-(m-i)) + a(i);
        end
    else
        result = a;
        for i=1:n
            result(m-(n-i)) = reuslt(m-(n-i)) - b(i);
        end
    end
end

%test:
%bezout([1,5,9,7,2],[1,5,6])
