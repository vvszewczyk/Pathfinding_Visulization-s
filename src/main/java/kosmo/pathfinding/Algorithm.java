package kosmo.pathfinding;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum Algorithm
{
    // Enums
    DIJKSTRA(
            DijkstraAlgorithm.class,
            "Dijkstra's description"
    ),

    Greedy_First_Best(
            GFBAlgorithm.class,
            "A*'s description"
    ),

    TEST1(
            Test1Algorithm.class,
            "Test 1 description"
    ),

    TEST2(
            Test2Algorithm.class,
            "Test 2 description"
    );

    // Attributes
    private final Class<?> algorithmClass;
    private final String description;

    // Constructor
    Algorithm(Class<?> algorithmClass, String description)
    {
        this.algorithmClass = algorithmClass;
        this.description = description;
    }

    // Methods
    public Runnable createInstance(Object argument)
    {
        try
        {
            Constructor<?> constructor = algorithmClass.getConstructor(argument.getClass());
            return (Runnable) constructor.newInstance(argument);
        }
        catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e)
        {
            throw new RuntimeException("Failed to instantiate algorithm", e);
        }
    }

    // Getters
    public String getDescription()
    {
        return description;
    }
}