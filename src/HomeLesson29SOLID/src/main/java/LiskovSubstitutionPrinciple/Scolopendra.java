package LiskovSubstitutionPrinciple;

public class Scolopendra extends Insect implements Poisonous, Crawling {
    public Scolopendra(String name) {
        super(name);
    }

    @Override
    public void poison() {
        System.out.println(name + " is poisonous");
    }

    @Override
    public void crawl() {
        System.out.println(name + " is crawling");
    }
}
