/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geoproject;

import geoproject.Coverage;
import geoproject.CoverageLongs;
import geoproject.Direction;
import geoproject.GeoHash;
import geoproject.LatLong;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author KGJQ6312
 */
public class GeoHashTest {

    public GeoHashTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /** 1
     * Test of adjacentHash method, of class GeoHash.
     */

    @Test
    public void testAdjacentHash_String_Direction1() {//a2b1c1
        System.out.println("adjacentHash");
        String hash = "gbsuv";
        Direction direction = Direction.TOP;
        String expResult = "gbsvj";
        String result = GeoHash.adjacentHash(hash, direction);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAdjacentHash_String_Direction6() {//a1b2c1
        System.out.println("adjacentHash");
        String hash = null;
        Direction direction = Direction.LEFT;
        //String expResult = "gbsuu";
        GeoHash.adjacentHash(hash, direction);
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test(expected = NullPointerException.class)
    public void testAdjacentHash_String_Direction7() {//a2b1c2
        System.out.println("adjacentHash");
        String hash = "gbsuv";
        Direction direction = null;
        // String expResult = "gbsuu";
        GeoHash.adjacentHash(hash, direction);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAdjacentHash_String_Direction4() {//a2b2c1
        System.out.println("adjacentHash");
        String hash = "";
        Direction direction = Direction.TOP;
        String expResult = "gbsvj";
        String result = GeoHash.adjacentHash(hash, direction);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /** 2
     * Test of right method, of class GeoHash.
     */
    @Test
    //a2b1
    public void testRight_base() {
        System.out.println("right");
        String hash = "gbsuv";
        String expResult = "gbsuy";
        String result = GeoHash.right(hash);
        assertEquals(expResult, result);
    }
    @Test(expected = IllegalArgumentException.class)
    //a1b2
    public void testRight_null() {
        System.out.println("right");
        String hash = null;
        // String expResult = "gbsuy";
        GeoHash.right(hash);
        //assertEquals(expResult, result);
    }
    @Test(expected = IllegalArgumentException.class)
    //a2b2
    public void testRight3() {
        System.out.println("right");
        String hash = "";
        // String expResult = "gbsuy";
        GeoHash.right(hash);
        //assertEquals(expResult, result);
    }

    /** 3
     * Test of Top method, of class GeoHash.
     */
    @Test
    //a2b1
    public void testTop_base() {
        System.out.println("top");
        String hash = "gbsuv";
        String expResult = "gbsvj";
        String result = GeoHash.top(hash);
        assertEquals(expResult, result);
    }
    @Test(expected = IllegalArgumentException.class)
    //a1b2
    public void testTop_null() {
        System.out.println("top");
        String hash = null;
        //  String expResult = null;
        GeoHash.top(hash);
        //assertEquals(expResult, result);
    }
    @Test(expected = IllegalArgumentException.class)
    //a1b2
    public void testTop3() {
        System.out.println("top");
        String hash = "";
        //  String expResult = null;
        GeoHash.top(hash);
        //assertEquals(expResult, result);
    }

    /** 4
     * Test of left method, of class GeoHash.
     */
    @Test
    public void testLeft() {// a2b1c1
        System.out.println("left");
        String hash = "gbsuv";
        String expResult = "gbsuu";
        String result = GeoHash.left(hash);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testLeft_null() {// a1b2c1
        System.out.println("left");
        String hash = null;
        //String expResult = "gbsuu";
        GeoHash.left(hash);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testLeft3() {// a1b2c1
        System.out.println("left");
        String hash = "";
        //String expResult = "gbsuu";
        GeoHash.left(hash);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /** 5
     * Test of bottom method, of class GeoHash.
     */

    @Test
    //a2b1
    public void testBottom_base() {
        System.out.println("bottom");
        String hash = "gbsuv";
        String expResult = "gbsut";
        String result = GeoHash.bottom(hash);
        assertEquals(expResult, result);
    }
    @Test(expected = IllegalArgumentException.class)
    //a1b2
    public void testBottom_null() {
        System.out.println("bottom");
        String hash = null;
        // String expResult = "gbsut";
        GeoHash.bottom(hash);
        // assertEquals(expResult, result);
    }
    @Test(expected = IllegalArgumentException.class)
    //a1b2
    public void testBottom3() {
        System.out.println("bottom");
        String hash = "";
        // String expResult = "gbsut";
        GeoHash.bottom(hash);
        // assertEquals(expResult, result);
    }
    /** 6
     * Test of neighbours method, of class GeoHash.
     */
    @Test
    //a2b1
    public void testNeighbours_base() {
        System.out.println("neighbours");
        String hash = "gbsuv";
        List<String> expResult = new ArrayList<>();
        String left = GeoHash.adjacentHash(hash, Direction.LEFT);
        String right = GeoHash.adjacentHash(hash, Direction.RIGHT);
        expResult.add(left);
        expResult.add(right);
        expResult.add(GeoHash.adjacentHash(hash, Direction.TOP));
        expResult.add(GeoHash.adjacentHash(hash, Direction.BOTTOM));
        expResult.add(GeoHash.adjacentHash(left, Direction.TOP));
        expResult.add(GeoHash.adjacentHash(left, Direction.BOTTOM));
        expResult.add(GeoHash.adjacentHash(right, Direction.TOP));
        expResult.add(GeoHash.adjacentHash(right, Direction.BOTTOM));
        List<String> result = GeoHash.neighbours(hash);
        assertEquals(expResult, result);
    }
    //TBC
    //a1b2
    @Test(expected = IllegalArgumentException.class)
    public void testNeighbours_null() {
        System.out.println("neighbours");
        String hash = null;
        GeoHash.neighbours(hash);

    }
    @Test(expected = IllegalArgumentException.class)
    //a2b2
    public void testNeighbours_base3() {
        System.out.println("neighbours");
        String hash = "";
        List<String> expResult = new ArrayList<>();
        String left = GeoHash.adjacentHash(hash, Direction.LEFT);
        String right = GeoHash.adjacentHash(hash, Direction.RIGHT);
        expResult.add(left);
        expResult.add(right);
        expResult.add(GeoHash.adjacentHash(hash, Direction.TOP));
        expResult.add(GeoHash.adjacentHash(hash, Direction.BOTTOM));
        expResult.add(GeoHash.adjacentHash(left, Direction.TOP));
        expResult.add(GeoHash.adjacentHash(left, Direction.BOTTOM));
        expResult.add(GeoHash.adjacentHash(right, Direction.TOP));
        expResult.add(GeoHash.adjacentHash(right, Direction.BOTTOM));
        List<String> result = GeoHash.neighbours(hash);
        assertEquals(expResult, result);
    }


    /** 7
     * Test of encodeHash method, of class GeoHash.
     */

    @Test
    //f1g1
    public void testEncodeHash_double_double_base() {
        System.out.println("encodeHash");
        double latitude = 50.0;
        double longitude = 50.0;
        String expResult = "v0gs3y0zh7w1";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }
    @Test(expected = IllegalArgumentException.class)
    //f2g1
    public void testEncodeHash_double_double_base2() {
        System.out.println("encodeHash");
        double latitude = -91.0;
        double longitude = 50.0;
        String expResult = "v0gs3y0zh7w1";
        GeoHash.encodeHash(latitude, longitude);
        // assertEquals(expResult, result);
    }
    @Test
    //f1g2
    public void testEncodeHash_double_double_base3() {
        System.out.println("encodeHash");
        double latitude = 50.0;
        double longitude = 181.0;
        String expResult = "zbzurypzp";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }

    /** 8
     * Test of encodeHash method, of class GeoHash.
     */
    //f1g1h1
    @Test
    public void testEncodeHash_LatLong_int() {
        System.out.println("encodeHash");
        LatLong p = new LatLong(10,90);
        int length = 2;
        String expResult = "w1";
        String result = GeoHash.encodeHash(p, length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //f2g1h1
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeHash_LatLong_int2() {
        System.out.println("encodeHash");
        LatLong p = new LatLong(-91,90);
        int length = 2;
        String expResult = "w1";
        GeoHash.encodeHash(p, length);
    }
    //f1g2h1
    @Test
    public void testEncodeHash_LatLong_int3() {
        System.out.println("encodeHash");
        LatLong p = new LatLong(-10,181);
        int length = 2;
        String expResult = "ry";
        String result = GeoHash.encodeHash(p, length);
        assertEquals(expResult, result);
    }
    //f1g1h2
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeHash_LatLong_int4() {
        System.out.println("encodeHash");
        LatLong p = new LatLong(10,90);
        int length = 15;
        String expResult = "w1dhjkfjdheyisk";
        String result = GeoHash.encodeHash(p, length);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /** 9
     * Test of encodeHash method, of class GeoHash.
     */
    @Test
    public void testEncodeHash_LatLong() {//f1g1
        System.out.println("encodeHash");
        LatLong p = new LatLong(10,90);
        String expResult = "w1b0bh2n0p05";
        String result = GeoHash.encodeHash(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeHash_LatLong2() {//f2g1
        System.out.println("encodeHash");
        LatLong p = new LatLong(-91,90);
        String expResult = "w1b0bh2n0p05";
        String result = GeoHash.encodeHash(p);
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    @Test
    public void testEncodeHash_LatLong3() {//f1g2
        System.out.println("encodeHash");
        LatLong p = new LatLong(10,181);
        String expResult = "xczbzuryp";
        String result = GeoHash.encodeHash(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /** 10
     * Test of encodeHash method, of class GeoHash.
     */
    @Test
    public void testEncodeHash_3args() {//f1g1h1
        System.out.println("encodeHash");
        double latitude = 10;
        double longitude = 90;
        int length = 2;
        String expResult = "w1";
        String result = GeoHash.encodeHash(latitude, longitude, length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeHash_3args2() {//f2g1h1
        System.out.println("encodeHash");
        double latitude = -91;
        double longitude = 90;
        int length = 2;
        String expResult = "w1";
        String result = GeoHash.encodeHash(latitude, longitude, length);
    }
    @Test
    public void testEncodeHash_3args3() {//f1g2h1
        System.out.println("encodeHash");
        double latitude = 10;
        double longitude = 181;
        int length = 2;
        String expResult = "xc";
        String result = GeoHash.encodeHash(latitude, longitude, length);
        assertEquals(expResult, result);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeHash_3args4() {//f1g1h2
        System.out.println("encodeHash");
        double latitude = 10;
        double longitude = 90;
        int length = 15;
        String expResult = "w1hfoeksnfhrusk";
        String result = GeoHash.encodeHash(latitude, longitude, length);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Test of adjacentHash method, of class GeoHash.
     */
    //boundry test -1
    @Test
    public void testAdjacentHash_3args_negoneSteps() {
        System.out.println("adjacentHash");
        String hash = "gbsvj";
        Direction direction = Direction.TOP;
        int steps = -1;
        String expResult = "gbsuv";
        String result = GeoHash.adjacentHash(hash, direction, steps);
        assertEquals(expResult, result);
    }
    //boundry test 0
    @Test
    public void testAdjacentHash_3args_0Steps() {
        System.out.println("adjacentHash");
        String hash = "gbsvj";
        Direction direction = Direction.TOP;
        int steps = 0;
        String expResult = "gbsvj";
        String result = GeoHash.adjacentHash(hash, direction, steps);
        assertEquals(expResult, result);
    }
    //boundry test 1
    @Test
    public void testAdjacentHash_3args_1Steps() {
        System.out.println("adjacentHash");
        String hash = "gbsvj";
        Direction direction = Direction.TOP;
        int steps = 1;
        String expResult = "gbsvm";
        String result = GeoHash.adjacentHash(hash, direction, steps);
        assertEquals(expResult, result);
    }

    //boundry test -90
    @Test
    public void testEncodeHash_double_double_neglatbound() {
        System.out.println("encodeHash");
        double latitude = -90.0;
        double longitude = 50.0;
        String expResult = "j0581b0bh2n0";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }
    //boundry test -89
    @Test
    public void testEncodeHash_double_double_neglat() {
        System.out.println("encodeHash");
        double latitude = -89.0;
        double longitude = 50.0;
        String expResult = "j05t9y0ckmw0";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }
    //boundry test -91
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeHash_double_double_invalidneglat() {
        System.out.println("encodeHash");
        double latitude = -91.0;
        double longitude = 50.0;

        GeoHash.encodeHash(latitude,longitude);

    }
    //boundry test 90
    @Test
    public void testEncodeHash_double_double_poslatbound() {
        System.out.println("encodeHash");
        double latitude = 90.0;
        double longitude = 50.0;
        String expResult = "vpgxczbzuryp";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }
    //boundry test 89
    @Test
    public void testEncodeHash_double_double_poslat() {
        System.out.println("encodeHash");
        double latitude = 89.0;
        double longitude = 50.0;
        String expResult = "vpgd3cbys6qp";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }
    //boundry test 91
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeHash_double_double_invalidposlat() {
        System.out.println("encodeHash");
        double latitude = 91.0;
        double longitude = 50.0;
        //String expResult = "";
        // String result = GeoHash.encodeHash(latitude, longitude);
        GeoHash.encodeHash(latitude, longitude);
        //assertEquals(expResult, result);
    }
    //boundry test -180
    @Test
    public void testEncodeHash_double_double_neglongbound() {
        System.out.println("encodeHash");
        double latitude = 50.0;
        double longitude = -180.0;
        String expResult = "b0bh2n0p0581";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }
    //boundry test -179
    @Test
    public void testEncodeHash_double_double_neglong() {
        System.out.println("encodeHash");
        double latitude = 50.0;
        double longitude = -179.0;
        String expResult = "b0bsqy0pjew1";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }
    //boundry test -181
    @Test
    public void testEncodeHash_double_double_invalidneglong() {
        System.out.println("encodeHash");
        double latitude = 50.0;
        double longitude = -181.0;
        String expResult = "b0bh2n0p0";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }
    //boundry test 180
    @Test
    public void testEncodeHash_double_double_poslongbound() {
        System.out.println("encodeHash");
        double latitude = 50.0;
        double longitude = 180;
        String expResult = "zbzurypzpgxc";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }
    //boundry test 179
    @Test
    public void testEncodeHash_double_double_poslong() {
        System.out.println("encodeHash");
        double latitude = 50.0;
        double longitude = 179.0;
        String expResult = "zbzk3npz479c";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }
    //boundry test 181
    @Test
    public void testEncodeHash_double_double_invalidposlong() {
        System.out.println("encodeHash");
        double latitude = 50.0;
        double longitude = 181.0;
        String expResult = "zbzurypzp";
        String result = GeoHash.encodeHash(latitude, longitude);
        assertEquals(expResult, result);
    }

    /**
     * Test of encodeHash method, of class GeoHash.
     */
    //boundry test -1
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeHash_LatLong_int_neglen() {
        System.out.println("encodeHash");
        LatLong p = new LatLong(10,90);
        int length = -1;
        // String expResult = "";
        GeoHash.encodeHash(p, length);
        // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //boundry test 1
    @Test
    public void testEncodeHash_LatLong_int_lower_bound_en() {
        System.out.println("encodeHash");
        LatLong p = new LatLong(10,90);
        int length = 1;
        String expResult = "w";
        String result = GeoHash.encodeHash(p, length);
        assertEquals(expResult, result);
    }
    //boundry test 12
    @Test
    public void testEncodeHash_LatLong_int_upper_bound_len() {
        System.out.println("encodeHash");
        LatLong p = new LatLong(10,90);
        int length = 12;
        String expResult = "w1b0bh2n0p05";
        String result = GeoHash.encodeHash(p, length);
        assertEquals(expResult, result);
    }
    //boundry test 13
    @Test(expected = IllegalArgumentException.class)
    public void testEncodeHash_LatLong_int_invalid_pos_len() {
        System.out.println("encodeHash");
        LatLong p = new LatLong(10,90);
        int length = 13;
        //String expResult = "";
        GeoHash.encodeHash(p, length);
        //assertEquals(expResult, result);
    }
    //boundry test 0
    @Test
    public void testCoverBoundingBoxMaxHashes_zeromax() {
        System.out.println("coverBoundingBoxMaxHashes");
        double topLeftLat = 80;
        double topLeftLon = 170;
        double bottomRightLat = 60;
        double bottomRightLon = 150;
        int maxHashes = 0;

        Coverage expResult = null;
        Coverage result = GeoHash.coverBoundingBoxMaxHashes(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon, maxHashes);
        assertEquals(expResult, result);
    }
    //boundry test 1
    @Test
    public void testCoverBoundingBoxMaxHashes_1max() {
        System.out.println("coverBoundingBoxMaxHashes");
       /* double topLeftLat = 80;
        double topLeftLon = 170;
        double bottomRightLat = 60;
        double bottomRightLon = 150;*/
        double topLeftLat = 42.819581;
        double topLeftLon = -73.950691 ;
        double bottomRightLat = 41.842967;
        double bottomRightLon = -72.727175;
        int maxHashes = 1;

        // Coverage expResult = null;
        Coverage result = GeoHash.coverBoundingBoxMaxHashes(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon, maxHashes);
        //  assertEquals(expResult, result);
        assertEquals(1, result.getHashes().size());
        assertEquals(2, result.getHashLength());
    }
    //boundry test 2
    @Test
    public void testCoverBoundingBoxMaxHashes_posmax() {
        System.out.println("coverBoundingBoxMaxHashes");
        double topLeftLat = 42.819581;
        double topLeftLon = -73.950691 ;
        double bottomRightLat = 41.842967;
        double bottomRightLon = -72.727175;
        int maxHashes = 2;
        Set<String> myArray = new TreeSet<String>();
        myArray.add("dr");

        Coverage expResult = new Coverage(myArray,52.95932614481936);
        Coverage result = GeoHash.coverBoundingBoxMaxHashes(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon, maxHashes);
        assertEquals(expResult.getHashes(), result.getHashes());
        assertEquals(expResult.getHashLength(), result.getHashLength());
        assertEquals(expResult.getRatio(), result.getRatio(),1);
    }
    //boundry test -1
    @Test
    public void testGridAsString_3args_negsize() {//a2b1n3o1
        System.out.println("gridAsString");
        String hash = "dr";
        int size = -1;
        Set<String> highlightThese =   Collections.<String> emptySet();
        String expResult = "";
        String result = GeoHash.gridAsString(hash, size, highlightThese);
        assertEquals(expResult, result);
    }
    //boundry test 0
    @Test
    public void testGridAsString_3args_0size() {//a2b1n3o1
        System.out.println("gridAsString");
        String hash = "dr";
        int size = 0;
        Set<String> highlightThese =   Collections.<String> emptySet();
        String expResult = "dr \n";
        String result = GeoHash.gridAsString(hash, size, highlightThese);
        assertEquals(expResult, result);
    }
    //boundry test 1
    @Test
    public void testGridAsString_3args_possize() {//a2b1n3o1
        System.out.println("gridAsString");
        String hash = "dr";
        int size = 1;
        Set<String> highlightThese =   Collections.<String> emptySet();
        String expResult = "f0 f2 f8 \n" + "dp dr dx \n" + "dn dq dw \n";
        String result = GeoHash.gridAsString(hash, size, highlightThese);
        assertEquals(expResult, result);
    }

    /**
     * Test of gridAsString method, of class GeoHash.
     */
    //boundry test -1
    @Test
    public void testGridAsString_5args_negonefromright() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = -1;
        int fromBottom = 2;
        int toRight = 5;
        int toBottom = 7;
        String expResult = "5 h j n p 0 1 \n" +
                "p 0 1 4 5 h j \n" +
                "5 h j n p 0 1 \n" +
                "p 0 1 4 5 h j \n" +
                "5 h j n p 0 1 \n" +
                "p 0 1 4 5 h j \n";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }
    //boundry test 0
    @Test
    public void testGridAsString_5args_0fromright() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 0;
        int fromBottom = 2;
        int toRight = 5;
        int toBottom = 7;
        String expResult = "h j n p 0 1 \n" +
                "0 1 4 5 h j \n" +
                "h j n p 0 1 \n" +
                "0 1 4 5 h j \n" +
                "h j n p 0 1 \n" +
                "0 1 4 5 h j \n";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }
    //boundry test 1
    @Test
    public void testGridAsString_5args_1fromright() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = 2;
        int toRight = 5;
        int toBottom = 7;
        String expResult = "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }
    //boundry test -1
    @Test
    public void testGridAsString_5args_negonefrombottom() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = -1;
        int toRight = 5;
        int toBottom = 7;
        String expResult = "m q r 2 3 \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }
    //boundry test 0
    @Test
    public void testGridAsString_5args_0frombottom() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = 0;
        int toRight = 5;
        int toBottom = 7;
        String expResult = "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }
    //boundry test 1
    @Test
    public void testGridAsString_5args_1frombottom() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = 1;
        int toRight = 5;
        int toBottom = 7;
        String expResult = "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n";

        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }
    //boundry test -1
    @Test
    public void testGridAsString_5args_negonetoRight() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = 2;
        int toRight = -1;
        int toBottom = 7;
        String expResult = "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" ;
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }
    //boundry test 0
    @Test
    public void testGridAsString_5args_0toRight() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = 2;
        int toRight = 0;
        int toBottom = 7;
        String expResult = "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" ;
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }
    //boundry test 1
    @Test
    public void testGridAsString_5args_1toRight() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = 2;
        int toRight = 1;
        int toBottom = 7;
        String expResult = "j \n" +
                "1 \n" +
                "j \n" +
                "1 \n" +
                "j \n" +
                "1 \n" ;
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }
    //boundry test -1
    @Test
    public void testGridAsString_5args_negone_toBottom() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = 2;
        int toRight = 5;
        int toBottom = -1;
        String expResult = "";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }
    //boundry test 0
    @Test
    public void testGridAsString_5args_0toBottom() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = 2;
        int toRight = 5;
        int toBottom = 0;
        String expResult = "";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }
    //boundry test 1
    @Test
    public void testGridAsString_5args_1toBottom() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = 2;
        int toRight = 5;
        int toBottom = 1;
        String expResult = "";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
    }



////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Test of decodeHash method, of class GeoHash.
     */
    @Test
    public void testDecodeHash() {//a2f1g1
        System.out.println("decodeHash");
        String geohash = "gbsuv";
        LatLong expResult = new LatLong(48.66943359375,-4.32861328125);
        LatLong result = GeoHash.decodeHash(geohash);
        assertEquals(expResult.getLat(),result.getLat(),0.0);
        assertEquals(expResult.getLon(),result.getLon(),0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of hashContains method, of class GeoHash.
     */
    @Test
    public void testHashContains() {//a2f1g1i1
        System.out.println("hashContains");
        String hash = "h";
        double lat = -68;
        double lon = 23;
        boolean expResult = true;
        boolean result = GeoHash.hashContains(hash, lat, lon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    @Test(expected = NullPointerException.class)
    public void testHashContains2() {//a1f1g1i1
        System.out.println("hashContains");
        String hash = null;
        double lat = -10;
        double lon = 30;
        boolean expResult = true;
        boolean result = GeoHash.hashContains(hash, lat, lon);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    @Test
    public void testHashContains3() {//a2f1g1i2
        System.out.println("hashContains");
        String hash = "gbsuv";
        double lat = -50;
        double lon = 10;
        boolean expResult = false;
        boolean result = GeoHash.hashContains(hash, lat, lon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    /**
     * Test of adjacentHash method, of class GeoHash.
     */
    @Test
    public void testAdjacentHash_3arg1() {//a2b1c1d2
        System.out.println("adjacentHash");
        String hash = "gbsuv";
        Direction direction = Direction.TOP;
        int steps = 100;
        String expResult = "gckvv";
        String result = GeoHash.adjacentHash(hash, direction, steps);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }
    @Test(expected = NullPointerException.class)
    public void testAdjacentHash_3arg2() {//a2b1c2d2
        System.out.println("adjacentHash");
        String hash = "gbsuv";
        Direction direction = null;
        int steps = 100;
        // String expResult = "ezugv";
        GeoHash.adjacentHash(hash, direction, steps);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }

    @Test
    public void testAdjacentHash_3arg3() {//a2b1c1d1
        System.out.println("adjacentHash");
        String hash = "gbsuv";
        Direction direction = Direction.TOP;
        int steps = -100;
        String expResult = "ezugv";
        String result = GeoHash.adjacentHash(hash, direction, steps);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAdjacentHash_3arg6() {//a1b2c1d2
        System.out.println("adjacentHash");
        String hash = null;
        Direction direction = Direction.TOP;
        int steps = 100;
        //  String expResult = "ezugv";
        GeoHash.adjacentHash(hash, direction, steps);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }

    //TBC




    /**
     * Test of hashLengthToCoverBoundingBox method, of class GeoHash.
     */
    @Test
    public void testHashLengthToCoverBoundingBox() {//f1g1h1
        System.out.println("hashLengthToCoverBoundingBox");
        double topLeftLat = 10;
        double topLeftLon = 90;
        double bottomRightLat =-68;
        double bottomRightLon = 23;
        int expResult = 0;
        int result = GeoHash.hashLengthToCoverBoundingBox(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }



    /**
     * Test of coverBoundingBox method, of class GeoHash.
     */
    @Test
    public void testCoverBoundingBox_4args() {//f1g1j1
        System.out.println("coverBoundingBox");
        double topLeftLat = 80;
        double topLeftLon = 90;
        double bottomRightLat = 10;
        double bottomRightLon = 20;

        Set<String> myArray = new TreeSet<String>();
        myArray.add("9");
        myArray.add("c");
        myArray.add("d");
        myArray.add("e");
        myArray.add("f");
        myArray.add("g");
        myArray.add("s");
        myArray.add("u");
        myArray.add("w");
        myArray.add("x");
        myArray.add("y");
        myArray.add("z");
        Coverage expResult = new Coverage(myArray,1.1970443349753694);
        Coverage result = GeoHash.coverBoundingBox(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }



    /**
     * Test of coverBoundingBoxMaxHashes method, of class GeoHash.
     */
    @Test
    public void testCoverBoundingBoxMaxHashes() {//f1g1j1k2
        System.out.println("coverBoundingBoxMaxHashes");
        double topLeftLat = 80;
        double topLeftLon = 170;
        double bottomRightLat = 60;
        double bottomRightLon = 150;
        int maxHashes = 10;
        Set<String> myArray = new TreeSet<String>();
        myArray.add("b");
        myArray.add("c");
        myArray.add("f");
        myArray.add("g");
        myArray.add("u");
        myArray.add("v");
        myArray.add("y");
        myArray.add("z");
        Coverage expResult = new Coverage(myArray,2.3823529411764706);
        Coverage result = GeoHash.coverBoundingBoxMaxHashes(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon, maxHashes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCoverBoundingBoxMaxHashes3() {//f1g1j2k1
        System.out.println("coverBoundingBoxMaxHashes");
        double topLeftLat = 50;
        double topLeftLon = -170;
        double bottomRightLat = -50;
        double bottomRightLon = -150;
        int maxHashes = 0;

        Coverage expResult = null;
        Coverage result = GeoHash.coverBoundingBoxMaxHashes(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon, maxHashes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of coverBoundingBox method, of class GeoHash.
     */
    @Test
    public void testCoverBoundingBox_5args() {//f1g1h1j1
        System.out.println("coverBoundingBox");
        double topLeftLat = 50;
        double topLeftLon = 60.0;
        double bottomRightLat = 40;
        double bottomRightLon = 30;
        int length = 1;
        Set<String> myArray = new TreeSet<String>();
        myArray.add("8");
        myArray.add("9");
        myArray.add("b");
        myArray.add("c");
        myArray.add("d");
        myArray.add("e");
        myArray.add("f");
        myArray.add("g");
        myArray.add("s");
        myArray.add("t");
        myArray.add("u");
        myArray.add("v");
        myArray.add("w");
        myArray.add("x");
        myArray.add("y");
        myArray.add("z");
        Coverage expResult = new Coverage(myArray,9.818181818181818);
        Coverage result = GeoHash.coverBoundingBox(topLeftLat, topLeftLon, bottomRightLat, bottomRightLon, length);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }



    /**
     * Test of heightDegrees method, of class GeoHash.
     */
    @Test
    public void testHeightDegrees() {//h1l2
        System.out.println("heightDegrees");
        int n = 2;
        double expResult = 5.625;
        double result = GeoHash.heightDegrees(n);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of widthDegrees method, of class GeoHash.
     */
    @Test
    public void testWidthDegrees() {//h1m2
        System.out.println("widthDegrees");
        int n = 2;
        double expResult = 11.25;
        double result = GeoHash.widthDegrees(n);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of gridAsString method, of class GeoHash.
     */
    @Test
    public void testGridAsString_3args() {//a2b1n3o1
        System.out.println("gridAsString");
        String hash = "dr";
        int size = 2;
        Set<String> highlightThese =   Collections.<String> emptySet();
        String expResult = "cc f1 f3 f9 fc \n" +
                "cb f0 f2 f8 fb \n" +
                "9z dp dr dx dz \n" +
                "9y dn dq dw dy \n" +
                "9v dj dm dt dv \n";
        String result = GeoHash.gridAsString(hash, size, highlightThese);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    @Test
    public void testGridAsString_3args2() {//a2b1n2o1
        System.out.println("gridAsString");
        String hash = "dr";
        int size = 1;
        Set<String> highlightThese =   Collections.<String> emptySet();
        String expResult = "f0 f2 f8 \n" +
                "dp dr dx \n" +
                "dn dq dw \n";
        String result = GeoHash.gridAsString(hash, size, highlightThese);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    @Test
    public void testGridAsString_3args3() {//a2b1n1o1
        System.out.println("gridAsString");
        String hash = "dr";
        int size = 0;
        Set<String> highlightThese =   Collections.<String> emptySet();
        String expResult = "dr \n";
        String result = GeoHash.gridAsString(hash, size, highlightThese);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    @Test
    public void testGridAsString_3args4() {//a1b2n3o1
        System.out.println("gridAsString");
        String hash = "";
        int size = 0;
        Set<String> highlightThese =   Collections.<String> emptySet();
        String expResult = " \n";
        String result = GeoHash.gridAsString(hash, size, highlightThese);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    @Test
    public void testGridAsString_3args6() {//a2b1n4o1
        System.out.println("gridAsString");
        String hash = "dr";
        int size = -1;
        Set<String> highlightThese =   Collections.<String> emptySet();
        String expResult = "";
        String result = GeoHash.gridAsString(hash, size, highlightThese);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    /**
     * Test of gridAsString method, of class GeoHash.
     */
    @Test
    public void testGridAsString_5args() {//a2b1p2q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = 2;
        int toRight = 5;
        int toBottom = 7;
        String expResult = "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testGridAsString_5args2() {//a2b1p1q2r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = -1;
        int fromBottom = 2;
        int toRight = 5;
        int toBottom = 7;
        String expResult = "5 h j n p 0 1 \n" +
                "p 0 1 4 5 h j \n" +
                "5 h j n p 0 1 \n" +
                "p 0 1 4 5 h j \n" +
                "5 h j n p 0 1 \n" +
                "p 0 1 4 5 h j \n";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testGridAsString_5args3() {//a2b1p2q1r2s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = -2;
        int toRight = 5;
        int toBottom = 7;
        String expResult = "t w x 8 9 \n" +
                "m q r 2 3 \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testGridAsString_5args4() {//a2b1p2q2r1s2
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 10;
        int fromBottom = 2;
        int toRight = -1;
        int toBottom = 7;
        String expResult = "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testGridAsString_5args5() {//a2b1p2q2r2s1
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 10;
        int fromBottom = 2;
        int toRight = 1;
        int toBottom = -7;
        String expResult = "";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of gridAsString method, of class GeoHash.
     */
    @Test
    public void testGridAsString_6args() {//a2b1p2q2r2s2o1
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = 2;
        int toRight = 5;
        int toBottom = 7;
        Set<String> highlightThese = Collections.<String> emptySet();
        String expResult = "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n";
        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom, highlightThese);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }

    @Test
    public void testGridAsString_6args2() {//a2b1p1q2r2s2o1
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = -1;
        int fromBottom = 2;
        int toRight = 5;
        int toBottom = 7;
        String expResult = "5 h j n p 0 1 \n" +
                "p 0 1 4 5 h j \n" +
                "5 h j n p 0 1 \n" +
                "p 0 1 4 5 h j \n" +
                "5 h j n p 0 1 \n" +
                "p 0 1 4 5 h j \n";
        Set<String> highlightThese = Collections.<String> emptySet();

        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom, highlightThese);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }
    @Test
    public void testGridAsString_6args3() {//a2b1p2q1r2s2o1
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 1;
        int fromBottom = -2;
        int toRight = 5;
        int toBottom = 7;
        String expResult = "t w x 8 9 \n" +
                "m q r 2 3 \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n" +
                "j n p 0 1 \n" +
                "1 4 5 h j \n";
        Set<String> highlightThese = Collections.<String> emptySet();

        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom, highlightThese);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }
    @Test
    public void testGridAsString_6args4() {//a2b1p2q2r1s2o1
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 10;
        int fromBottom = 2;
        int toRight = -1;
        int toBottom = 7;
        String expResult = "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n";
        Set<String> highlightThese = Collections.<String> emptySet();

        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom, highlightThese);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }
    @Test
    public void testGridAsString_6args5() {//a2b1p2q2r1s2o1
        System.out.println("gridAsString");
        String hash = "h";
        int fromRight = 10;
        int fromBottom = 2;
        int toRight = 1;
        int toBottom = -7;
        String expResult = "";
        Set<String> highlightThese = Collections.<String> emptySet();

        String result = GeoHash.gridAsString(hash, fromRight, fromBottom, toRight, toBottom, highlightThese);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }


}
