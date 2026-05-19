public class AnimalTipoFactory {

    public static IAnimalTipo getTipo(String tipo){
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("AnimalTipo" + tipo);
            objeto = classe.newInstance();
        }catch (Exception e) {
            throw new IllegalArgumentException("Tipo de Animal Inexistente");
        }
        if (!(objeto instanceof IAnimalTipo)) {
            throw new IllegalArgumentException("Tipo de Animal Inexistente");
        }
        return (IAnimalTipo) objeto;
    }
}
