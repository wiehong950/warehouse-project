package id.co.indivara.jdt12.warehouseproject.Enum;

public enum EnumTransaction {
    WAREHOUSETOWAREHOUSE("Warehouse To Warehouse"),
    WAREHOUSETOSTORE("Warehouse To Store"),
    SUPPLYTOWAREHOUSE("Supply To Warehouse");
    private String text;

    EnumTransaction(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
