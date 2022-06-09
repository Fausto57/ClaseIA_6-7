package LogicaDifusa;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Principal {

    public static void main(String[] args) {

        FIS fis = FIS.load("src/LogicaDifusa/brake.fcl", true);

        if (fis == null) {
            System.err.println("Error de Archivo");
            System.exit(1);
        }

        JFuzzyChart.get().chart(fis.getFunctionBlock("break"));

        fis.setVariable("Presion", 10);
        fis.setVariable("Velocidad", 100);

        fis.evaluate();

        Variable b = fis.getFunctionBlock("break").getVariable("Freno");
        JFuzzyChart.get().chart(b, b.getDefuzzifier(), true);
        System.out.println(b.getValue());

    }

}