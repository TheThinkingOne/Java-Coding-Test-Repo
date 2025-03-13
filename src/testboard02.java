public class testboard02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        int x=5, y=0, z=0;
        y = x++;
        z = --x;
        System.out.println(x + " " + y + " " + z);

        int a1 = 1, a2 = 6;
        while (--a2 > 0) {
            a1++;
            System.out.println(a2);
        }
        System.out.println(a1);
        System.out.println(a2);
    }
}
