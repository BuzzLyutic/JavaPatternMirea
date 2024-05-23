package Practice_6.Prototype;

class ConcretePrototype1 implements Prototype {
    private String name;
    public ConcretePrototype1(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }
    public ConcretePrototype1 clone(){
        return new ConcretePrototype1(this.name);
    }
}
