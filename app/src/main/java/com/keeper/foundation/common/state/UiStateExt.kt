package com.keeper.foundation.common.state

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

public fun <T> Flow<T>.toDataState(): Flow<DataState<T>> {
    return map {
        try {
            DataState.Success(it)
        } catch (e: Exception) {
            DataState.Failure(error = e.message)
        }
    }.catch {
        emit(DataState.Failure(it.message))
    }
}

public inline fun <T, R> Flow<T>.mapDataState(
    crossinline transform: suspend (value: T) -> R?,
): Flow<DataState<R>> {
    return map {
        try {
            DataState.Success(transform(it)!!)
        } catch (e: Exception) {
            DataState.Failure(error = e.message)
        }
    }.catch {
        emit(DataState.Failure(it.message))
    }
}

@OptIn(ExperimentalContracts::class)
public fun <T> DataState<T>?.isSuccess(): Boolean {
    contract {
        returns(true) implies (this@isSuccess is DataState.Success)
    }
    return this is DataState.Success
}

@OptIn(ExperimentalContracts::class)
public fun <T> DataState<T>?.isFailure(): Boolean {
    contract {
        returns(true) implies (this@isFailure is DataState.Failure)
    }
    return this is DataState.Failure
}

@OptIn(ExperimentalContracts::class)
public fun <T> DataState<T>?.isLoading(): Boolean {
    contract {
        returns(true) implies (this@isLoading is DataState.Loading)
    }
    return this is DataState.Loading
}

public fun <T> DataState<T>?.getDataOrNull(): T? {
    return (this as? DataState.Success)?.data
}
