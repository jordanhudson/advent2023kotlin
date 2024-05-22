val strToNum = mapOf(
  "one" to "1",
  "two" to "2",
  "three" to "3",
  "four" to "4",
  "five" to "5",
  "six" to "6",
  "seven" to "7",
  "eight" to "8",
  "nine" to "9"
)

fun day1() {
  val answer = readFile("day1.txt")
    ?.sumOf {
      val pattern = """(\d|one|two|three|four|five|six|seven|eight|nine)"""

      val first = Regex(pattern).find(it)!!.value

      // lets pretend i can't figure out overlapping regex
      var charCount = 0
      var match: MatchResult?
      do {
        charCount++
        val endPiece = it.takeLast(charCount)
        match = Regex(pattern).find(endPiece)
      } while (match == null)
      val last = match.value

      val firstDigit = strToNum.getOrDefault(first, first)
      val lastDigit = strToNum.getOrDefault(last, last)

      "$firstDigit$lastDigit".toInt()
    }

  println(answer)
}
