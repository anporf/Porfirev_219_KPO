class ButtonArithmetic implements Callable {
    char type;
    public ButtonArithmetic(char type) {
        this.type = type;
    }

    public Integer call(Integer a, Integer b) {
        if (type == '+') {
            return a + b;
        } else {
            return a - b;
        }
    }
}
