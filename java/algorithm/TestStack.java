import java.util.Stack;

public class TestStack {

    public static void main(String[] args) {

        /*
         * stack = LIFO data structure. Last-In First-Out
         * stores objects into a sort of "vertical tower"
         * push() to add to the top
         * pop() to remove from the top
         * 
         * uses of stacks?
         * 1. undo/redo features in text editors
         * 2. moving back/forward through browser history
         * 3. backtracking algorithms (maze, file directories)
         * 4. calling functionss (call stack)
         */

        Stack<String> stack = new Stack<String>();

        System.out.println("stack.empty() : " + stack.empty());

        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("DOOM");
        stack.push("BorderLands");
        stack.push("FFVII");

        System.out.println("stack.empty() : " + stack.empty());
        System.out.println("stack : " + stack);

        System.out.println("stack.peek() : " + stack.peek());

        System.out.println("stack.search(\"FFVII\") : " + stack.search("FFVII"));
        System.out.println("stack.search(\"Minecraft\") : " + stack.search("Minecraft"));
        System.out.println("stack.search(\"FallOut\") : " + stack.search("FallOut"));

        String myFavGame = stack.pop();
        System.out.println("stack : " + stack);
        System.out.println("myFavGame : " + myFavGame);
    }

}
