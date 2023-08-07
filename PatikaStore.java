import java.util.Scanner;

public class PatikaStore {
    Main main=new Main();
    public void  run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            main.start();
            System.out.print(
                    "PATİKA STORE ÜRÜN YÖNETİM PANELİ\n" +
                            "1 - Notebook İşlemleri\n" +
                            "2 - Cep Telefonu İşlemleri\n" +
                            "3 - Marka Listele\n" +
                            "4 - Çıkış Yap\n" +
                            "Yapmak İstediğiniz İşlemi Seçin : "
            );
            int secim = scanner.nextInt();
            main.start();
            switch (secim) {
                case 1:
                    NoteBook notebook=new NoteBook();
                    notebook.menu();
                    break;
                case 2:
                    Smartphone smartphone =new Smartphone();
                    smartphone.menu();
                    break;
                case 3:
                    Brand.markalariEkranaYaz();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Geçersiz İşlem !");
            }
        }
    }

}