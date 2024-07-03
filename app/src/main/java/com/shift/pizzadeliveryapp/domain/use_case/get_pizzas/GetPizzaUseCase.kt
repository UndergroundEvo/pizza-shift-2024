package com.shift.pizzadeliveryapp.domain.use_case.get_pizzas

import com.shift.pizzadeliveryapp.R
import com.shift.pizzadeliveryapp.common.Resource
import com.shift.pizzadeliveryapp.data.remote.dto.toPizzaCatalog
import com.shift.pizzadeliveryapp.domain.models.PizzaCatalog
import com.shift.pizzadeliveryapp.domain.repository.PizzaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPizzaUseCase @Inject constructor(
    private val repository: PizzaRepository
) {
    operator fun invoke(): Flow<Resource<PizzaCatalog>> = flow {
        try {
            emit(Resource.Loading())
            val pizzas = repository.getPizzas().toPizzaCatalog()
            emit(Resource.Success<PizzaCatalog>(pizzas))
        } catch (e: HttpException){
            emit(Resource.Error<PizzaCatalog>(e.localizedMessage ?: R.string.http_error.toString()))
        } catch (e: IOException){
            emit(Resource.Error<PizzaCatalog>(e.localizedMessage ?: R.string.io_error.toString()))
        }

    }
}