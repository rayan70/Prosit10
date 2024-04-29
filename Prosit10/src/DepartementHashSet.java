import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class DepartementHashSet<T extends Departement> implements IDepartement<T> {
    private HashSet<T> departements;

    public DepartementHashSet() {
        this.departements = new HashSet<>();
    }

    @Override
    public void ajouterDepartement(T t) {
        departements.add(t);
    }

    @Override
    public boolean rechercherDepartement(String nom) {
        for (T dept : departements) {
            if (dept.getNomDepartement().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(T t) {
        return departements.contains(t);
    }

    @Override
    public void supprimerDepartement(T t) {
        departements.remove(t);
    }

    @Override
    public void displayDepartement() {
        for (T dept : departements) {
            System.out.println(dept);
        }
    }

    @Override
    public TreeSet<T> trierDepartementById() {
        TreeSet<T> sortedDepartements = new TreeSet<>((dept1, dept2) -> {
            if (dept1.getId() == dept2.getId()) {
                return dept1.getNomDepartement().compareTo(dept2.getNomDepartement());
            }
            return Integer.compare(dept1.getId(), dept2.getId());
        });

        sortedDepartements.addAll(departements);
        return sortedDepartements;
    }
}
