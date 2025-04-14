package com.wesleyadiel.fittrackerpro.presentation.meal.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wesleyadiel.fittrackerpro.domain.meal.model.Meal

@Composable
fun MealItem(meal: Meal, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = meal.name)
            Text(text = "Date: ${meal.date}")
            Text(text = "Protein: ${meal.protein}g")
            Text(text = "Carbs: ${meal.carbs}g")
            Text(text = "Fat: ${meal.fat}g")
            Text(text = "Calories: ${meal.calories}")
        }
    }
}