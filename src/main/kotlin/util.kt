fun readFile(path: String): List<String>? {
  return object {}.javaClass.getResourceAsStream(path)?.bufferedReader()?.readLines()
}