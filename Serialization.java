import java.io.*;
import java.util.ArrayList;
/// Serialization example
class Serialization implements Serializable {
    String name;
    int id;
    transient String address;

    Serialization(String name, int id) {
        this.name = name;
        this.id = id;
    }
    Serialization(String name, int id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\nID: " + this.id + "\nAddress: " + this.address;
    }


    public static void main(String[] args) {
        Serialization stu1 = new Serialization("Sowmya" , 1);
        Serialization stu2 = new Serialization("Mortha", 2, "Lingampally");
        ArrayList<Serialization> stuList = new ArrayList<Serialization>();
        stuList.add(stu1);
        stuList.add(stu2);

        try{
            String filename = "SampleSerializable.txt";
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(stu1);
//            oos.writeObject(stu2);
            oos.writeObject(stuList);
            oos.close();
            fos.close();
            System.out.println("Serialization Completed");

            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Serialization> studentArrayList = (ArrayList<Serialization>) ois.readObject();
//            Student stu3 = (Student) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Deserialization Completed");
            System.out.println(studentArrayList.toString());
        } catch (FileNotFoundException exp) {
            System.out.println("File Not Found - " + exp);
        } catch (IOException exp) {
            System.out.println("IO Exception - " + exp);
        } catch (ClassNotFoundException exp) {
            System.out.println("ClassNotFoundException Exception - " + exp);
        }
    }
}