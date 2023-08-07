import java.util.ArrayList;
import java.util.Scanner;

public class Smartphone extends Product {

    Scanner scanner=new Scanner(System.in);
    private static ArrayList<Smartphone> smartphones =new ArrayList<>();
    private static int id2=1;
    public Smartphone(String name, Brand brand, int fiyat, int stok, double indirimOrani, int ram, double ekranBoyutu, int hafiza) {
        super(id2, name, brand, fiyat, stok, indirimOrani, ram, ekranBoyutu, hafiza);
        id2++;
    }

    public Smartphone() {
    }
    @Override
    public void menu() {
        System.out.print(
                "1- Yeni Ceptelefonu Ekle\n" +
                        "2- Ceptelefonu Listesini Görüntüle\n" +
                        "3- Ceptelefonu Sil\n" +
                        "4- Ceptelefonlarını ID Numaralarına Göre Sırala\n" +
                        "5- Ceptelefonlarını Markaya Göre Filtrele\n" +
                        "Yapmak İstediğiniz İşlemi Seçiniz : "
        );
        int secim= scanner.nextInt();
        if(secim==1)addItem();
        if (secim==2||secim==4)getProducts();
        if (secim==3)deleteItem();
        if(secim==5)markafiltrele();
    }


    public void print(ArrayList<Smartphone> cepTelefons1) {
        if (cepTelefons1 == null) {
            cepTelefons1 = this.smartphones;
        }
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı (TL)         | Markası         | Stoğu(ADET)        | İndirim Oranı (%)      | RAM (GB)    | Ekran Boyutu (Inch)      | Hafızası   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Smartphone n : cepTelefons1) {
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    n.getId(), n.getName(), n.getPrice(), n.getMarka().getName(), n.getStock(),
                    n.getDiscountRate(), n.getRam(), n.getScreenSize(), n.getMemory());
        }

    }

    @Override
    public void markafiltrele() {
        scanner.nextLine();
        System.out.print("Filtrelemek istediğiniz marka : ");
        String filtre= scanner.nextLine();
        ArrayList<Smartphone>cepTelefons1=new ArrayList<>();
        for(Smartphone c: smartphones){
            if(filtre.equals(c.getMarka().getName())){
                cepTelefons1.add(c);
            }
        }
        print(cepTelefons1);
    }

    @Override
    public void addItem() {
        System.out.print("CEP TELEFONU\nAdı : ");
        scanner.nextLine();
        String name=scanner.nextLine();
        Brand.markalariEkranaYaz();
        System.out.print("Marka : ");
        Brand brand = Brand.getMarka(scanner.nextInt());
        System.out.print("Hafızası : ");
        int hafiza= scanner.nextInt();
        System.out.print("RAM : ");
        int ram= scanner.nextInt();
        System.out.print("Ekran Boyutu : ");
        double ekranBoyutu= scanner.nextDouble();
        System.out.print("Stok : ");
        int stok=scanner.nextInt();
        System.out.print("Fiyatı : ");
        int fiyat= scanner.nextInt();
        System.out.print("İndirim Oranı : ");
        double indirimOrani=scanner.nextDouble();


        Smartphone smartphone =new Smartphone(name, brand,fiyat,stok,indirimOrani,ram,ekranBoyutu,hafiza);
        this.smartphones.add(smartphone);
        System.out.println("ID : "+ smartphone.getId());
    }

    @Override
    public void getProducts() {

        if (smartphones.isEmpty()) {
            System.out.println("Henüz ürün yok");
        } else {
            print(null);
        }
    }

    @Override
    public void deleteItem() {
        getProducts();
        System.out.print("Silinecek Ürünün ID'si : ");
        int id = scanner.nextInt();
        smartphones.remove(id - 1);
        getProducts();
    }


}