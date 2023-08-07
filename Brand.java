import java.util.Comparator;
import java.util.TreeSet;

public class Brand {
    static Main main=new Main();
    private int id;
    private String name;

    public Brand(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Brand getMarka(int id) {
        for(Brand m: brandListesi){
            if(id==m.getId()){
                return m;
            }
        }
        return null;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    private static TreeSet<Brand> brandListesi = new TreeSet<>(new Comparator<Brand>() {
        @Override //sıralama
        public int compare(Brand o2, Brand o1) {
            return o2.getName().compareTo(o1.getName());
        }
    });

    static {
        markaolustur();
        // markalariEkranaYaz();
    }

    public static void markaolustur() {
        brandListesi.add(new Brand(1, "Samsung"));
        brandListesi.add(new Brand(2, "Lenovo"));
        brandListesi.add(new Brand(3, "Apple"));
        brandListesi.add(new Brand(4, "Huawei"));
        brandListesi.add(new Brand(5, "Casper"));
        brandListesi.add(new Brand(6, "Asus"));
        brandListesi.add(new Brand(7, "HP"));
        brandListesi.add(new Brand(8, "Xiaomi"));
        brandListesi.add(new Brand(9, "Monster"));
    }
    public static void markalariEkranaYaz(){
        System.out.println("MARKALAR : ");
        for(Brand markayaz: brandListesi){
            System.out.println(markayaz.getId()+" - "+markayaz.getName());
        }
        main.start();
    }
}