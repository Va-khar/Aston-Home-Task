public class Park {
    private String name;
    private String location;

    public Park(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double cost;

        public Attraction(String attractionName, String workingHours, double cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void Info() {
            System.out.println("Название Аттракциона: " + attractionName + "\n" +
                    "Рабочие часы: " + workingHours + "\n" +
                    "Цена билета: " + cost);
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Парк отдыха", "Измайловский парк");
        Attraction shootingGallery = park.new Attraction("Охотник", "12:00 - 20:00", 100);
        Attraction ferrisWheel = park.new Attraction("Вид", "10:00 - 18:00", 300);
        Attraction trampoline = park.new Attraction("Зефир", "10:00 - 20:00", 250);

        shootingGallery.Info();
        ferrisWheel.Info();
        trampoline.Info();
    }
}
