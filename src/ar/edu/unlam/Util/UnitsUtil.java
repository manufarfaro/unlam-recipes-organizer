package ar.edu.unlam.Util;

public class UnitsUtil {
    /**
     * Small method to quickly convert recipes units to integer so we can compare units as floats.
     * This is just to standardized and are only contemplated a few cases for the presented use case.
     * @Todo there should be a better way to do this.
     * @param inputUnit
     * @return
     */
    public static float convertRecipesUnitToFloat(String inputUnit) {
        try {
            return Float.parseFloat(inputUnit);
        } catch (NumberFormatException e) {
            switch (inputUnit) {
                case "500gr":
                case "1/2":
                    return 0.5F;
                case "250gr":
                case "3/4":
                    return 0.25F;
                case "150gr":
                    return 0.15F;
                case "125gr":
                case "1/8":
                    return 0.125F;
                case "30gr":
                    return 0.03F;
            }
        }
        return 0;
    }
    public static float convertRecipesUnitToFloat(int inputUnit) {
        return UnitsUtil.convertRecipesUnitToFloat(String.valueOf(inputUnit));
    }
}
