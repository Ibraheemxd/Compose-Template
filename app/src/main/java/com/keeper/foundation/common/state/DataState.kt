package com.keeper.foundation.common.state

sealed interface DataState<out T> {

    /**
     * Represents the initial state of the UI, where neither data is loaded nor has a request been sent.
     * */
    data object Init : DataState<Nothing>

    /**
     * Represents a loading state of the UI, where data is currently being fetched.
     *
     * @property index The current index of the loading process, indicating progress.
     * @property count The total number of items to be loaded.
     *
     */
    data class Loading(
        val index: Int = 0,
        val count: Int = MAX_COUNT_UNKNOWN,
    ) : DataState<Nothing> {

        /**
         * Calculates the percentage of the loading process that has been completed.
         *
         * @return The percentage of completion as an integer value between 0 and 100.
         */
        fun getPercentage(): Int {
            return (index / count) * 100
        }

        companion object {
            const val MAX_COUNT_UNKNOWN = -1
        }
    }

    /**
     * Represents a successful state of the UI, where data has been fetched and is ready to be displayed.
     *
     * @property data The fetched data of type T, holding the content to be presented in the UI.
     */
    data class Success<T>(
        val data: T
    ) : DataState<T>

    /**
     * Represents a failed state of the UI, where an error has occurred during data fetching or processing.
     *
     * @property error A string containing the error message, providing details for debugging or user feedback.
     * @property errorCode Used for specific error handling logic.
     */
    data class Failure(
        val error: String? = null,
        val errorCode: Int? = null,
    ) : DataState<Nothing>
}

