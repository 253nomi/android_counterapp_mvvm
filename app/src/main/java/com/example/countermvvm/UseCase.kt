// A generic UseCase for suspendable (asynchronous) operations
abstract class UseCase<Type: Any, in Params> {
    abstract suspend operator fun invoke(params: Params): Either<Failure, Type>
}

// A generic UseCase for instant (synchronous) operations
abstract class InstantUseCase<Type: Any, in NoParams> {
    abstract operator fun invoke(params: NoParams): Either<Failure, Type>
}

// Used when there are no parameters required for the UseCase
object NoParams


sealed class Either<out L, out R> {
    data class Left<out L>(val value: L) : Either<L, Nothing>()
    data class Right<out R>(val value: R) : Either<Nothing, R>()
}

data class Failure(val message: String)