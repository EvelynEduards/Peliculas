package Config;

import java.nio.file.Path;
import java.nio.file.Paths;
    
public interface AppConfig {
    
    
    static final String BASE = "src/data";
    
    static final String BINARY_FILE_PATH = "peliculas.dat"; //cambiar solo el nombre de los archivos
    
    static final String CSV_FILE_PATH = "peliculas.csv";

    
    public static Path getRutaCSV(){
        return Paths.get(BASE, CSV_FILE_PATH);
    }
    
    public static Path getRutaBin(){
        return Paths.get(BASE, BINARY_FILE_PATH);
    }
    
    public static String getRutaCSVString(){
        return getRutaCSV().toString();
    }
    
    public static String getRutaBinString(){
        return getRutaBin().toString();
    }  
    
}
