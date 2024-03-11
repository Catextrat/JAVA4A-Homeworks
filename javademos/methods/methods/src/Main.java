public class Main {

    public static void main(String[] args) {
        sayiBulmaca();
    }

    //camel casing
    public static void sayiBulmaca() {
        int[] sayilar = new int[]{1, 2, 5, 7, 9, 0};
        int aranacak = 6;
        boolean varMı = false;


        for (int sayi : sayilar) {
            if (sayi == aranacak) {
                varMı = true;
                break;
            }
        }

        String mesaj = "";
        if (varMı) {
            mesaj = "Sayı mevcuttur: " + aranacak;
            //System.out.println("Sayı mevcuttur: "+aranacak);
            mesajVer("Sayı mevcuttur: " + aranacak);
        } else {
            //System.out.println("Sayı mevcut değildir: "+aranacak);
            mesajVer("Sayı mevcut değildir: " + aranacak);
        }
    }

    public static void mesajVer(String mesaj) {
        System.out.println(mesaj);
    }
}