class PersonHashFunction implements HashFunction<String> {
    public PersonHashFunction() {
    }

    @Override
    public int hash(String s) {
        int counter = 0;
        char[] strInChars = s.toCharArray();

        for(int i = 0; i < s.length(); ++i) {
            counter += strInChars[i] * i;
        }
        return counter % s.length();
    }
}