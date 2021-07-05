package javalang.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestRectangleSolutionTest {

    @Test
    void shouldReturnLargestRec_ForSortedList(){
        //Arrange
        int [] sample1 = {1,2,3};
        LargestRectangleSolution solution = new LargestRectangleSolution();

        //Act
        long result = solution.largestRectangle(sample1);

        //Assert
        assertEquals(4, result);
    }

    @Test
    void shouldReturnLargestRec_ForUnSortedList(){
        //Arrange
        int [] sample1 = {3,2,4,3,1,4};
        LargestRectangleSolution solution = new LargestRectangleSolution();

        //Act
        long result = solution.largestRectangle(sample1);

        //Assert
        assertEquals(8, result);
    }
}
