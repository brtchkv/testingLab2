import _aux.TanCalculator;
import base.CosCalculator;
import base.LnCalculator;
import base.SinCalculator;
import fileOutput.Printer;


public class Main {
    public static void main(String[] args) {
        Printer.printToCsv("sin.csv", SinCalculator.getInstance()::calculate, -Math.PI/6, 13*Math.PI/6, Math.PI/6);
        Printer.printToCsv("ln.csv", LnCalculator.getInstance()::calculate, 0.1, Math.pow(Math.E, 3), 0.1);
        Printer.printToCsv("tan.csv", TanCalculator.getInstance()::calculate, -Math.PI/2, Math.PI/2, Math.PI/24);
        Printer.printToCsv("cos.csv", CosCalculator.getInstance()::calculate, -13*Math.PI/6, 13*Math.PI/6, Math.PI/6);
    }
}
