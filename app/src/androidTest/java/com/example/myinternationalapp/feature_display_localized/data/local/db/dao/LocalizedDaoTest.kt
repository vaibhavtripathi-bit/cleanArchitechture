package com.example.myinternationalapp.feature_display_localized.data.local.db.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.example.myinternationalapp.data.SelectedLocale
import com.example.myinternationalapp.feature_display_localized.data.local.db.AppLocalizedDB
import com.example.myinternationalapp.feature_display_localized.data.local.db.entity.DBSelectedLocale
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class LocalizedDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppLocalizedDB
    private lateinit var dao: LocalizedDao

    @Before
    fun setup() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(
            appContext,
            AppLocalizedDB::class.java,
        ).allowMainThreadQueries().build()
        dao = database.localizedDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun verifyInsertSelectedLocale() = runBlockingTest {
        val expectedValue = SelectedLocale.GERMAN
        val searchItem = DBSelectedLocale(
            locale = SelectedLocale.GERMAN
        )
        dao.insertSelectedLocale(searchItem)

        val selectedLocale = dao.getSelectedLocale().first()

        assertThat(selectedLocale.first().locale).isEqualTo(expectedValue)
    }

    @Test
    fun removeSearchTermReturnSuccess() = runBlockingTest {
        dao.insertSelectedLocale(
            DBSelectedLocale(
                locale = SelectedLocale.ENGLISH
            )
        )
        dao.insertSelectedLocale(
            DBSelectedLocale(
                locale = SelectedLocale.FRENCH
            )
        )
        dao.insertSelectedLocale(
            DBSelectedLocale(
                locale = SelectedLocale.GERMAN
            )
        )

        val selectedLocale = dao.getSelectedLocale().first()

        assertThat(selectedLocale.size).isEqualTo(1)
    }
}