###1. 循环阵的行列式

给定复数域上的$n$级循环矩阵
$$
    A = \begin{bmatrix}
        a_1 & a_2 & a_3 & \cdots & a_n\\
        a_n & a_1 & a_2 & \cdots & a_{n-1}\\
        a_{n-1} & a_{n} & a_1 & \cdots & a_{n-2}\\
        \vdots & \vdots & \vdots & & \vdots\\
        a_2 & a_3 & a_4 & \cdots & a_1\\
    \end{bmatrix}
$$
计算$A$的行列式

**解:** 引入多项式$f(t) = a_1+a_2t+a_3t^2+\cdots+a_nt^{n-1}$, 和$n$次单位根$\varepsilon_k = \mathrm{e}^{\frac{2k\pi\mathrm{i}}{n}}, k = 0,1,\cdots, n-1$. 
    构造复数域$\mathbb{C}$上的$n$级Vandermonde方阵 $$B = \begin{bmatrix}
        1 & 1 & \cdots & 1 \\
        \varepsilon_1 & \varepsilon_2 & \cdots & \varepsilon_n\\
        \vdots & \vdots & & \vdots \\
        \varepsilon_1^{n - 1} & \varepsilon_2^{n - 1} & \cdots & \varepsilon_n^{n - 1}
    \end{bmatrix}$$
于是$$
    AB = \begin{bmatrix}
        f(\varepsilon_1) & f(\varepsilon_2) & \cdots & f(\varepsilon_n)\\
        \vdots & \vdots & & \vdots \\
        \varepsilon_1^{n - 1}f(\varepsilon_1) & \varepsilon_2^{n - 1}f(\varepsilon_2) & \cdots & \varepsilon_n^{n - 1}f(\varepsilon_n)
    \end{bmatrix}$$
注意到右边的矩阵第$k$列有公因子$f(\varepsilon_k)$, 于是
$$
    \det(A)\det(B) = \det(AB) = f(\varepsilon_1)f(\varepsilon_2)\cdots f(\varepsilon_n) \det(B).
$$
根据Vandermonde阵的性质知道$\det(B) \neq 0$, 于是
$$
    \det(A) = f(\varepsilon_1)f(\varepsilon_2)\cdots f(\varepsilon_n)
$$
