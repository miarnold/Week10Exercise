package edu.matc.week10Exercise;

import com.sun.glass.ui.Accessible;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Basic;

import static org.junit.Assert.*;

public class RileyWatchesTvTest {

    @Test
    public void runTest() throws Exception {
        RileyWatchesTv rileyWatchesTv = new RileyWatchesTv();
        rileyWatchesTv.startThreads();
    }

}