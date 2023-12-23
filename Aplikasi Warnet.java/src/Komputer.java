import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Komputer {
    String nomorKomputer;
    boolean tersedia;
    double tarifPerJam;

    Komputer(String nomorKomputer, double tarifPerJam) {
        this.nomorKomputer = nomorKomputer;
        this.tersedia = true;
        this.tarifPerJam = tarifPerJam;
    }

    void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}