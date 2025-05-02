package com.example.fetch_take_home_challenge.presentation.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetch_take_home_challenge.domain.util.Result
import com.example.fetch_take_home_challenge.domain.repository.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject internal constructor(
    private val listRepository: ListRepository
) : ViewModel() {
    private val _state = MutableStateFlow(ListState())
    val state = _state
        .onStart { getList() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            ListState()
        )

    private fun getList() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            when (val result = listRepository.getList()) {
                is Result.Success -> {
                    val list = result.data
                        ?.filter {
                            !it.name.isNullOrBlank()
                        }?.groupBy {
                            it.listId
                        }
                    Log.d("ViewModel", list?.size.toString())
                    _state.update { it.copy(isLoading = false, list = list ?: emptyMap()) }
                }

                is Result.Error -> {
                    _state.update { it.copy(isLoading = false) }
                    Log.e("ListViewModel", result.message.toString())
                }

                else -> {}
            }
        }
    }
}