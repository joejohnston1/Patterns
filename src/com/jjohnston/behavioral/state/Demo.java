package com.jjohnston.behavioral.state;

import com.jjohnston.behavioral.state.ui.Player;
import com.jjohnston.behavioral.state.ui.UI;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {

    /**
     * Use the State pattern when you have an object that behaves differently depending on its current state,
     * the number of states is enormous, and the state-specific code changes frequently.
     *
     *  The pattern suggests that you extract all state-specific code into a set of distinct classes. As a result,
     *  you can add new states or change existing ones independently of each other, reducing the maintenance cost.
     *
     *  Use the pattern when you have a class polluted with massive conditionals that alter how the class behaves
     *  according to the current values of the class’s fields.
     *
     *  The State pattern lets you extract branches of these conditionals into methods of corresponding state classes.
     *  While doing so, you can also clean temporary fields and helper methods involved in state-specific code out of your main class.
     *
     * Pros
     * - Single Responsibility Principle. Organize the code related to particular states into separate classes.
     * - Open/Closed Principle. Introduce new states without changing existing state classes or the context.
     * - Simplify the code of the context by eliminating bulky state machine conditionals.
     *
     * Cons
     * - Applying the pattern can be overkill if a state machine has only a few states or rarely changes.
     *
     * Relations with Other Patterns
     *
     * - Bridge, State, Strategy (and to some degree Adapter) have very similar structures.
     * Indeed, all of these patterns are based on composition, which is delegating work to other objects.
     * However, they all solve different problems. A pattern isn’t just a recipe for structuring your code in a specific way.
     * It can also communicate to other developers the problem the pattern solves.
     *
     * - State can be considered as an extension of Strategy. Both patterns are based on composition: they change the
     * behavior of the context by delegating some work to helper objects. Strategy makes these objects completely
     * independent and unaware of each other. However, State doesn’t restrict dependencies between concrete states,
     * letting them alter the state of the context at will.
     *
     * @param args
     */
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
