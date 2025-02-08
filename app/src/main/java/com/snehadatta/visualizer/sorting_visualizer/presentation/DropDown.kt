package com.snehadatta.visualizer.sorting_visualizer.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DropDown(defaultItem: MutableState<Int>) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
    ) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(Icons.Default.MoreVert, contentDescription = "More options")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("BUBBLE SORT") },
                onClick = {
                    expanded = false
                    defaultItem.value = 0
                }
            )
            DropdownMenuItem(
                text = { Text("SELECTION SORT") },
                onClick = {
                    expanded = false
                    defaultItem.value = 1
                }
            )
            DropdownMenuItem(
                text = { Text("INSERTION SORT") },
                onClick = {
                    expanded = false
                    defaultItem.value = 2
                }
            )
            DropdownMenuItem(
                text = { Text("MERGE SORT") },
                onClick = {
                    expanded = false
                    defaultItem.value = 3
                }
            )
            DropdownMenuItem(
                text = { Text("QUICK SORT") },
                onClick = {
                    expanded = false
                    defaultItem.value = 4
                }
            )

        }
    }
}