package dev.kalink.game.RobotTests;

import dev.kalink.game.Navigation.Game.Field;
import dev.kalink.game.Navigation.Geometry.Coord;
import dev.kalink.game.Tools.Logger.LoggerTools;
import dev.kalink.game.Tools.Logger.OfflineLoggerTools;
import dev.kalink.game.Tools.Move.MoveTools;

class TestOffline {
    LoggerTools logger = new OfflineLoggerTools();
    LoggerTools.RobotTime time = logger.getRobotTimeClass();

    public static void main(String[] args) {
        LoggerTools logger = new OfflineLoggerTools();
        LoggerTools.RobotTime time = logger.getRobotTimeClass();

        // Output logger tests
        TestOffline tests = new TestOffline();
        tests.messageNoStackTest();
        tests.messageStackTest();
        tests.elapseTimeTest();

        Coord[] field_points = new Coord[]{new Coord(-50, 50), new Coord(50, 50), new Coord(-50, 50), new Coord(-50, -50)};
        Field field = new Field(field_points, 3.6576);
        //3.6576

        logger.add("field values", field.toString());
        logger.add("actual distances: ", String.valueOf(field.getEdges()[0].getLength()));
        logger.add("actual distances: ", String.valueOf(field.getEdges()[1].getLength()));

        double converted_test1 = field.convertToCoord(1.8287999999999998);
        double conv_test_2 = field.convertToMeters(50);
        logger.add("field coord dist", String.valueOf(converted_test1));
        logger.add("length half field", String.valueOf(conv_test_2));
        logger.update(false);

    }

    void elapseTimeTest() {
        // Elapsed time test (seconds, milliseconds, nanoseconds)
        time.reset();
        logger.add(String.valueOf(time.startTime()), "");
        logger.add(String.valueOf(time.time()), "");
        logger.add("Elapsed seconds, milliseconds, nanoseconds:","");

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.add("", String.valueOf(time.seconds() + " " + String.valueOf(time.milliseconds() + " " + String.valueOf(time.nanoseconds()))));
            logger.update(true);
        }
    }

    void messageStackTest() {
        // Messages stacking
        logger.add("stack1", "a");
        logger.update(false);
        logger.add("stack2", "b");
        logger.update(false);
        logger.add("stack3", "c");

        logger.update(true);
    }

    void messageNoStackTest() {
        // Messages stacking
        logger.add("stack1", "a", true);
        logger.add("stack2", "b", true);
        logger.add("stack3", "c", true);
    }
}