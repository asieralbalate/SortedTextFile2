import java.io.*;

public class SortedTextFile {
    private String fileName;
    private int numElements = 0;
    private int elementAt;


    public SortedTextFile(String fileName) throws IOException {
        this.fileName = fileName;
        File file = new File(fileName);
        if (!file.exists()){
            file.createNewFile();
        }
    }
    public String getName() {
        return fileName;
    }

    public void put(String newLine) throws IOException {
        File file = new File(fileName);
        File temp = new File("temp.txt");
        BufferedReader input = null;
        PrintWriter output = null;
        try {
            String line;
            input = new BufferedReader(new FileReader(file));
            output = new PrintWriter(new FileWriter(temp));
            boolean alreadyInserted = false;
            while ((line = input.readLine()) != null) {
                if (!alreadyInserted && line.compareTo(newLine) > 0) {
                    output.println(newLine);
                    alreadyInserted = true;
                }
                output.println(line);
            }
            if (!alreadyInserted){
                output.println(newLine);
            }
            file.delete();
            temp.renameTo(file);
        }finally{
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
        }
    }
    public int getNumElements() throws IOException {
        BufferedReader in = null;
        String line;
        try{
            in = new BufferedReader(new FileReader(fileName));
            while ((line = in.readLine()) != null){
                numElements++;
            }
            return numElements;
        } finally {
            if ((in != null)){
                in.close();
            }
        }
    }

    public String getElementAt(int elementAt) throws IOException {
        BufferedReader in = null;
        try{
            String line;
            int counter = 0;
            in = new BufferedReader(new FileReader(fileName));
            while ((line = in.readLine()) != null){
                counter++;
                if (counter == elementAt){
                    return line;
                }
            }
            return null;
        } finally {
            if ((in != null)){
                in.close();
            }
        }
    }
    public void removeElementAt(int numLine) throws IOException {
        File file = new File(fileName);
        File temp = new File("temp.txt");
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            String line;
            int counter = 0;
            in = new BufferedReader(new FileReader(file));
            out = new PrintWriter(new FileWriter(temp));
            while ((line = in.readLine()) != null){
                counter++;
                if (counter != numLine){
                    out.println(line);
                }
            }
            file.delete();
            temp.renameTo(file);
        } finally {
            if (in != null){
                in.close();
            }
            if (out != null){
                out.close();
            }
        }
    }
    public boolean isEmpty() throws IOException {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(fileName));
            return in.readLine() == null;
        } finally {
            if (in != null){
                in.close();
            }
        }
    }
    public void emptyFile() throws IOException {
        File file = new File(fileName);
        file.delete();
        file.createNewFile();
    }

    public void print() throws IOException {
        BufferedReader in = null;
        try{
            String line;
            in = new BufferedReader(new FileReader(fileName));
            while ((line = in.readLine()) != null){
                System.out.println(line);
            }
        } finally {
            if ((in != null)){
                in.close();
            }
        }
    }

    public boolean existElement (String line){

    }
}
