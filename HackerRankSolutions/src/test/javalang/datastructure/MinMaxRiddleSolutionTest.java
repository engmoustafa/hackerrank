package javalang.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxRiddleSolutionTest {
    @Test
    public void shouldRunSimpleCase(){
        //Arrange
        long intArray[] = {2, 6, 1, 12};
        MinMaxRiddleSolution solution = new MinMaxRiddleSolution();
        long expectedResult[] = {12, 2 , 1 , 1};
        //Act
        long[] result  = MinMaxRiddleSolution.riddle(intArray);

        //Assert
        assertArrayEquals(expectedResult,result);
    }

    @Test
    public void shouldRunSimpleCase2(){
        //Arrange
        long intArray[] = {1, 2, 3, 5, 1, 13, 3};
        MinMaxRiddleSolution solution = new MinMaxRiddleSolution();
        long expectedResult[] = {13, 3, 2, 1, 1, 1, 1};
        //Act
        long[] result  = MinMaxRiddleSolution.riddle(intArray);

        //Assert
        assertArrayEquals(expectedResult,result);
    }


    @Test
    public void shouldRunSimpleCase3(){
        //Arrange
        long intArray[] = {3, 5, 4, 7, 6, 2};
        MinMaxRiddleSolution solution = new MinMaxRiddleSolution();
        long expectedResult[] = {7, 6, 4, 4, 3, 2};
        //Act
        long[] result  = MinMaxRiddleSolution.riddle(intArray);

        //Assert
        assertArrayEquals(expectedResult,result);
    }

}
