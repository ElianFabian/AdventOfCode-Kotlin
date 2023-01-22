package elianfabian.adventofcode.util

interface Puzzle<in I : Any, out O : Any>
{
    val question: String

    fun getResult(input: I): O
}

data class PuzzleInfo<I : Any, out O : Any>(
    val input: I,
    val parts: Set<Puzzle<I, O>>,
)

fun <I : Any, O : Any> showPuzzleResults(puzzleInfo: PuzzleInfo<I, O>, indentationCount: Int = 0)
{
    val indentation = "\t".repeat(indentationCount)
    
    puzzleInfo.parts.forEachIndexed { index, puzzle ->
        println("$indentation ${index + 1}. ${puzzle.question}")
        println("$indentation - Your answer is: ${puzzle.getResult(puzzleInfo.input)}\n")
    }
}