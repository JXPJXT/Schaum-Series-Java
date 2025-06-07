import java.util.*;
import javax.management.RuntimeErrorException;

// The public class must match the file name: TestUniversity
public class TestUniversity {
    public static void main(String[] args) {
        University jsu = new University("JavaStateUniversity");
        Professor adams = new Professor("Adams", Professor.Rank.ASSOC);
        Professor baker = new Professor("Baker", Professor.Rank.ASST);
        Professor cohen = new Professor("Cohen", Professor.Rank.PROF);
        Set<Professor> profs = new HashSet<Professor>();
        Collections.addAll(profs, adams, baker, cohen);
        jsu.addDepartment("Computer Science", profs);

        Professor davis = new Professor("Davis", Professor.Rank.ASST);
        Professor evans = new Professor("Evans", Professor.Rank.INSTR);
        profs.clear(); // Clear the set for the new department
        Collections.addAll(profs, davis, evans, baker);
        jsu.addDepartment("Biology", profs);

        adams.setRank(Professor.Rank.PROF);
    }
}

// All other classes can be non-public
class Person {
    private final String name;

    public Person(String name) {
        this.name = new String(name);
    }

    public String getName() {
        return new String(name);
    }
}

class Professor extends Person {
    public static enum Rank {INSTR, ASST, ASSOC, PROF}

    private Rank rank;

    public Professor(String name, Rank rank) {
        super(name);
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }
}

class University {
    private static class Department {
        final String name;
        Set<Professor> members;

        public Department(String name) {
            this.name = new String(name);
            this.members = new HashSet<Professor>();
        }

        public void add(Professor professor) {
            members.add(professor);
        }
    }

    private final String name;
    private Map<String, Department> departments;

    public University(String name) {
        this.name = new String(name);
        this.departments = new TreeMap<String, Department>();
    }

    public String getName() {
        return new String(name);
    }

    public void addDepartment(String name, Set<Professor> members) {
        Department dept = new Department(name);
        departments.put(name, dept);
        for (Professor prof : members) {
            dept.add(prof);
        }
    }

    public void add(Professor prof, String deptName) {
        Department dept = departments.get(deptName);
        if (dept == null) {
            throw new RuntimeErrorException(new Exception(deptName + " does not exist."));
        } else {
            dept.add(prof);
        }
    }

    public Set<String> departments() {
        return departments.keySet();
    }
}