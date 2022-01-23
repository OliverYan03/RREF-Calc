package test;

import main.model.RREF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


public class RREFTEST {
    private RREF rref;
    double[][] m1;
    @BeforeEach
    void setup() {
        rref = new RREF();
        m1 = new double[][]{
                {2, 2, 0},
                {4, 1, 3},
                {0, 1, 0}
        };
    }

    @Test
    void testAddRow() {
       double[][] mTest = new double[][] {
               {2, 2, 0},
               {6, 3, 3},
               {0, 1, 0}
       };
       double[][] temp = rref.rowAdd(m1,0,1);
       assertEquals(Arrays.deepToString(mTest),Arrays.deepToString(temp));
    }

    @Test
    void testAddRowScalar() {
        double[][] mTest = new double[][] {
                {2, 2, 0},
                {4, 1, 3},
                {6, 7, 0}
        };
        double[][] temp = rref.rowAddScale(m1,0,2,3);
        assertTrue(Arrays.deepToString(mTest).equals(Arrays.deepToString(temp)));
    }

    @Test
    void testRowScale() {
        double[][] mTest = new double[][] {
                {2, 2, 0},
                {4, 1, 3},
                {0, 5, 0}
        };
        double[][] temp = rref.rowScale(m1,2,5);
        assertEquals(Arrays.deepToString(mTest),Arrays.deepToString(temp));
    }

    @Test
    void testRowSwap() {
        double[][] mTest = new double[][] {
                {2, 2, 0},
                {0, 1, 0},
                {4, 1, 3}
        };
        double[][] temp = rref.rowSwap(m1,2,1);
        assertEquals(Arrays.deepToString(mTest),Arrays.deepToString(temp));
    }

    @Test
    void testRREF() {
        double[][] mTest = new double[][] {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        double[][] temp = rref.Rref(m1);
        assertEquals(Arrays.deepToString(mTest),Arrays.deepToString(temp));
    }


}
