public class Integrais {
    // Função que você deseja integrar
    public static double fa(double x) {
        return Math.exp(-x);
    }

    public static double fb(double x) {
        return Math.pow(x, 0.5);
    }

    public static double trapezoidalRuleA(double a, double b, int n) {
        double h = (b - a) / n; // Largura dos subintervalos
        double sum = 0.5 * (fa(a) + fa(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += fa(x);
        }
        return h * sum;
    }

    public static double trapezoidalRuleB(double a, double b, int n) {
        double h = (b - a) / n; // Largura dos subintervalos
        double sum = 0.5 * (fb(a) + fb(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += fb(x);
        }
        return h * sum;
    }

    public static double trapezoidalRuleC(double a, double b, int n) {
        double h = (b - a) / n; // Largura dos subintervalos
        double sum = 0.5 * (fc(a) + fc(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += fc(x);
        }
        return h * sum;
    }

    public static double trapezoidalRuleD(double a, double b, int n) {
        double h = (b - a) / n; // Largura dos subintervalos
        double sum = 0.5 * (fd(a) + fd(b));
        for (int i = 1; i < n; i++) {
            double x = a + i * h;
            sum += fd(x);
        }
        return h * sum;
    }

    private static double fd(double x) {
        return 1 / (1 + x);
    }

    private static double fc(double x) {
        return 1.0 / Math.pow(x, 0.5);
    }

    private static double fa2(double x) {
        return Math.exp(-x);
    }

    // (N*H^3*derivada''(c))/12
    public static double erroA(double b, double a, double n) {
        double aux = fa2(b);
        double h = (b - a) / n; // Largura dos subintervalos
        aux = (aux * n * (Math.pow(h, 3))) / 12;
        return aux;

    }
    private static double fb2(double x) {
        return -1/(4*Math.pow(x, 3/2));
    }

    public static double errob(double b, double a, double n) {
        double aux = fb2(b);
        double h = (b - a) / n; // Largura dos subintervalos
        aux = (aux * n * (Math.pow(h, 3))) / 12;
        return aux;

    }

    private static double fc2(double x) {
        return 3/(4*Math.pow(x, 5/2));
    }

    public static double erroc(double b, double a, double n) {
        double aux = fc2(b);
        double h = (b - a) / n; // Largura dos subintervalos
        aux = (aux * n * (Math.pow(h, 3))) / 12;
        return aux;

    }

    private static double fd2(double x) {
        return 2/(Math.pow(1+ x, 3));
    }

    public static double errod(double b, double a, double n) {
        double aux = fd2(b);
        double h = (b - a) / n; // Largura dos subintervalos
        aux = (aux * n * (Math.pow(h, 3))) / 12;
        return aux;

    }

    public static void main(String[] args) {

        double a = 1.0;
        double a2 = 1.0;
        double a3 = 2;
        double a4 = 0;

        double b = 2.0;
        double b2 = 4;
        double b3 = 5;
        double b4 = 0.6;

        double result = 0, result2 = 0, result3 = 0, result4 = 0;
        int n = 4, n1, n2,n3, n4;
        result = trapezoidalRuleA(a, b, n);
        result2 = trapezoidalRuleB(a2, b2, n);
        result3 = trapezoidalRuleC(a3, b3, n);
        result4 = trapezoidalRuleD(a4, b4, n);
       
        System.out.println("Questão 1");
        System.out.println(" ");
        System.out.println("Letra A: " + result);
        System.out.println("Letra B: " + result2);
        System.out.println("Letra C: " + result3);
        System.out.println("Letra D: " + result4);
        System.out.println(" ");

        //Questão 2
        n = 1;
        double resultA1 = 0;
        double resultA2 = 0;
        double resultA3 = 0;
        double resultA4 = 0;
        do {
            resultA1 = erroA(b, a, n);
            n++;
        } while (resultA1 >= 0.00001);
        n1 = n;
        n = 1;

        do {
            resultA2 = errob(b2, a2, n);
            n++;
        } while (resultA2 >= 0.00001);
        n2 = n;
        n = 1;

        do {
            resultA3 = erroc(b3, a3, n);
            n++;
        } while (resultA3 >= 0.00001);
        n3 = n;
        n = 1;

        do {
            resultA4 = errod(b4, a4, n);
            n++;
        } while (resultA4 >= 0.00001);
        n4 = n;
        n = 1;

        System.out.println("Questão 2");
        System.out.println(" ");
        System.out.println(resultA1 + " Quantidade de intervalos: " + n1);
        System.out.println(resultA2 + " Quantidade de intervalos: " + n2);
        System.out.println(resultA3 + " Quantidade de intervalos: " + n3);
        System.out.println(resultA4 + " Quantidade de intervalos: " + n4);

    }
}

// (N*H^3 derivada''(c))/12