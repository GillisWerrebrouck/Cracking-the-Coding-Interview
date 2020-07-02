import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Algorithm to create the build order for a project based on given dependencies.
 * 
 * @author Gillis Werrebrouck
 */

public class Build_Order {
    public static void main(final String args[]) {
        ArrayList<String> projects = new ArrayList<String>();
        projects.add("a");
        projects.add("b");
        projects.add("c");
        projects.add("d");
        projects.add("e");
        projects.add("f");

        dependency[] dependencies = {
            new dependency("a", "d"),
            new dependency("f", "b"),
            new dependency("b", "d"),
            new dependency("f", "a"),
            new dependency("d", "c"),
            // new dependency("d", "f"), // creates a loop in project dependencies
        };

        try {
            ArrayList buildOrder = getBuildOrder(projects, dependencies);
            System.out.println(buildOrder);
        } catch(Exception e) {
            System.out.print(e.getMessage());
        }
    }

    private static Map<String, ArrayList<String>> createInconnections(ArrayList<String> projects, dependency[] dependencies) {
        Map<String, ArrayList<String>> inConnections = new HashMap<>();

        for(int i = 0; i < projects.size(); i++) {
            inConnections.put(projects.get(i), new ArrayList<>());
        }

        for(int i = 0; i < dependencies.length; i++) {
            ArrayList list = inConnections.get(dependencies[i].dependency);
            list.add(dependencies[i].parent);
            inConnections.put(dependencies[i].dependency, list);
        }

        return inConnections;
    }

    private static void removeTask(String task, Map<String, ArrayList<String>> inConnections) {
        for(Map.Entry<String, ArrayList<String>> entry : inConnections.entrySet()) {
            entry.getValue().removeIf(x -> (task.equals(x.toString())));
        }
        inConnections.remove(task);
    }

    private static ArrayList<String> getBuildOrder(ArrayList<String> projects, dependency[] dependencies) throws Exception {
        Map<String, ArrayList<String>> inConnections = createInconnections(projects, dependencies);
        ArrayList<String> buildOrder = new ArrayList<String>();

        while(!inConnections.isEmpty()) {
            int previousSize = inConnections.size();
            for(Map.Entry<String, ArrayList<String>> entry : inConnections.entrySet()) {
                if(entry.getValue().isEmpty()) {
                    String task = entry.getKey();
                    buildOrder.add(task);
                    removeTask(task, inConnections);
                    break;
                }
            }

            if(previousSize == inConnections.size()) {
                throw new Exception("loop detected in project dependencies, not able to create a build order");
            }
        }

        return buildOrder;
    }
}

class dependency {
    public String parent;
    public String dependency;

    public dependency(String parent, String dependency) {
        this.parent = parent;
        this.dependency = dependency;
    }
}
