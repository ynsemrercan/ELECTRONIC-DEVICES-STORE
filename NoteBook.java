import java.util.ArrayList;
import java.util.Scanner;

public class NoteBook extends Product {


    Main main = new Main();
    Scanner scanner = new Scanner(System.in);
    private static ArrayList<NoteBook> noteBooks = new ArrayList<>();

    private static int idd=1;

    public NoteBook(String name, Brand brand, int fiyat, int stok, double indirimOrani, int ram, int ekranBoyutu, int hafiza) {
        super(idd, name, brand, fiyat, stok, indirimOrani, ram, ekranBoyutu, hafiza);
        idd++;
    }

    public NoteBook() {

    }
    public void menu() {
        System.out.print(
                "1- Yeni Notebook Ekle\n" +
                        "2- Notebook Listesini Görüntüle\n" +
                        "3- Notebook Sil\n" +
                        "4- Notebookları ID Numaralarına Göre Sırala\n" +
                        "5- Notebookları Markaya Göre Filtrele\n" +
                        "Yapmak İstediğiniz İşlemi Seçiniz : "
        );
        int secim = scanner.nextInt();
        main.start();
        if (secim==1) addItem();
        if (secim == 5) markafiltrele();
        if (secim == 2 ||secim==4) getProducts();
        if (secim==3) deleteItem();
    }

    public void print(ArrayList<NoteBook> noteBookArrayList) {
        if(noteBookArrayList ==null) noteBookArrayList =this.noteBooks;
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stoğu        | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");

        for (NoteBook n: noteBookArrayList){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    n.getId(),n.getName(),n.getPrice(),n.getMarka().getName(),n.getStock(),
                    n.getDiscountRate(),n.getRam(),n.getScreenSize(),n.getMemory());
        }
    }

    @Override
    public void addItem() {
        System.out.print("Notebook\nismi : ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Fiyatı : ");
        int fiyat= scanner.nextInt();
        System.out.print("Stoğu : ");
        int stok= scanner.nextInt();
        System.out.print("İndirim Oranı : ");
        double indirimOrani=scanner.nextDouble();
        System.out.print("RAM : ");
        int ram= scanner.nextInt();
        System.out.print("Ekran Boyutu : ");
        int ekranBoyutu= scanner.nextInt();
        System.out.print("Hafızası : ");
        int hafiza= scanner.nextInt();
        System.out.println("Marka seçin ");
        Brand.markalariEkranaYaz();
        Brand brand = Brand.getMarka(scanner.nextInt());

        System.out.println();
        NoteBook notebook=new NoteBook( name, brand, fiyat, stok, indirimOrani, ram, ekranBoyutu, hafiza);
        this.noteBooks.add(notebook);

        System.out.println("ID : "+notebook.getId());
    }

    @Override
    public void getProducts() {

        if (noteBooks.isEmpty()) {
            System.out.println("Henüz Ürün Yok");
        } else {
            print(null);
        }

    }

    @Override
    public void deleteItem() {
        getProducts();
        System.out.print("Silinecek Olan Ürünün ID'si : ");
        int sid= scanner.nextInt();
        noteBooks.remove(sid-1);
        getProducts();
    }

    public void markafiltrele(){
        scanner.nextLine();
        Brand.markalariEkranaYaz();
        System.out.print("Filtrelenecek Marka : ");
        String filtre= scanner.nextLine();
        ArrayList<NoteBook> filtrele=new ArrayList<>();
        for(NoteBook n: noteBooks){
            if(filtre.equals(n.getMarka().getName())){
                filtrele.add(n);
            }
        }
        print(filtrele);
    }



}