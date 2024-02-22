package View;

import Model.Produto;

public class Test {
    public static void main(String[] args) {
        Produto ps4 = new Produto("Playstation 4", 3449.99);
        Produto xbox = new Produto("Xbox 360 ", 499.99);

        System.out.println(ps4);
        System.out.println(xbox);
    }
}
