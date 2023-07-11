package com.contactkaran.mywordsdictionary.presentation.saved_words.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.contactkaran.mywordsdictionary.domain.utils.WordOrder
import com.contactkaran.mywordsdictionary.ui.theme.SpaceSize

@Composable
fun OrderRadioButtons(
    wordOrder: WordOrder, onOrderChange: (WordOrder) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        CustomRadioButton(text = "Ascending",
            selected = wordOrder is WordOrder.Ascending,
            onSelect = { onOrderChange(WordOrder.Ascending) })

        Spacer(modifier = Modifier.width(SpaceSize.Large))

        CustomRadioButton(text = "Descending",
            selected = wordOrder is WordOrder.Descending,
            onSelect = { onOrderChange(WordOrder.Descending) })
    }
}