public class Main {

    public static void main(String[] args) {
        String ogrenci1="Ayşegül";
        String ogrenci2="Çilek";
        String ogrenci3="Berk";
        String ogrenci4="Engin";

        System.out.println(ogrenci1);
        System.out.println(ogrenci2);
        System.out.println(ogrenci3);
        System.out.println(ogrenci4);

        System.out.println("-----------------");

        String[] ogrenciler = new String[4];
        ogrenciler [0]="Ayşegül";
        ogrenciler [1]="Çilek";
        ogrenciler [2]="Berk";
        ogrenciler [3]="Engin";

        for(int i=0;i<ogrenciler.length;i++) {
            System.out.println(ogrenciler[i]);
        }
        System.out.println("-----------------");


        for (String ogrenci:ogrenciler){
            System.out.println(ogrenci);
        }
    }
}
