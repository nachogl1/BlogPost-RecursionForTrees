package solutions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InOrder;
import org.mockito.Mockito;
import utils.Console;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.inOrder;
import static solutions.Utils.TREE;

public class PreDFSNoRecursiveTests {
    private Console console;
    private Solution solution;


    @BeforeEach
    void setUp() {
        console = Mockito.mock(Console.class);
        solution = new SolutionNoRecursiveDFS(console);

    }

    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void givenAExistingSearchTerm_WhenUsingInOrderDFS_ThenReturnTrue(String input) {
        boolean result = solution.search(TREE, input);
        assertTrue(result);
    }

    @Test
    void givenAExistingSearchTerm_WhenUsingInOrderDFS_ThenReturnIfExistsTraversingInCorrectOrder() {
        InOrder inOrder = inOrder(console);

        boolean result = solution.search(TREE, "9");

        assertTraverseInCorrectInOrder(inOrder);
        assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource({"m", "invalidValue"})
    void givenASearchTermThatDoesNotExist_WhenUsingInOrderDFS_ThenReturnIfExistsInCorrectOrder(String input) {
        InOrder inOrder = inOrder(console);

        boolean result = solution.search(TREE, input);

        assertTraverseInCorrectInOrder(inOrder);
        inOrder.verify(console).print("7"); //Specific for this case
        assertFalse(result);
    }


    private void assertTraverseInCorrectInOrder(InOrder inOrder) {
        inOrder.verify(console).print("1");
        inOrder.verify(console).print("2");
        inOrder.verify(console).print("4");
        inOrder.verify(console).print("8");
        inOrder.verify(console).print("5");
        inOrder.verify(console).print("3");
        inOrder.verify(console).print("6");
        inOrder.verify(console).print("9");
    }
}
