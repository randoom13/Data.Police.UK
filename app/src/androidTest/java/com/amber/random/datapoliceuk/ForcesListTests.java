package com.amber.random.datapoliceuk;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.KeyEvent;
import android.widget.EditText;

import com.amber.random.datapoliceuk.api.BackendServiceApi;
import com.amber.random.datapoliceuk.assertions.EmptyTextViewTextAssertion;
import com.amber.random.datapoliceuk.assertions.TextViewTextAssertion;
import com.amber.random.datapoliceuk.model.force.ForceItem;
import com.amber.random.datapoliceuk.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.contrib.DrawerActions.open;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.amber.random.datapoliceuk.matchers.CustomMatchers.navigationIconMatcher;
import static com.amber.random.datapoliceuk.matchers.CustomMatchers.withRecyclerView;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ForcesListTests {
    @Rule
    public TestRule mDaggerRule = new TestRule();
    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<MainActivity>
            (MainActivity.class, false, false);
    @Mock
    BackendServiceApi mBackendServiceApi;

    private static List<ForceItem> getDummyListForces() {
        List<ForceItem> forces = new ArrayList<ForceItem>();
        forces.add(ForceItem.create("230", "lorem"));
        forces.add(ForceItem.create("123", "ipsum"));
        forces.add(ForceItem.create("34", "color"));
        forces.add(ForceItem.create("100", "sit"));
        forces.add(ForceItem.create("220", "amet"));
        forces.add(ForceItem.create("110", "consectetuer"));
        return forces;
    }

    @Test
    public void initialization() {
        ForceItem item1 = ForceItem.create("110", "test test1");
        ForceItem item2 = ForceItem.create("230", "test test2");
        List<ForceItem> forces = new ArrayList<>();
        forces.add(item1);
        forces.add(item2);
        when(mBackendServiceApi.getAllForces()).thenReturn(Flowable.fromArray(forces));
        mainActivity.launchActivity(null);
        onView(withId(R.id.forces)).check(ViewAssertions.matches((isDisplayed())));
        onView(withRecyclerView(R.id.forces).onViewAtPosition(0, android.R.id.text1))
                .check(new TextViewTextAssertion(item1.name()));
        onView(withRecyclerView(R.id.forces).onViewAtPosition(1, android.R.id.text1))
                .check(new TextViewTextAssertion(item2.name()));
    }

    @Test
    public void testSingleSearch() {
        when(mBackendServiceApi.getAllForces()).
                thenReturn(Flowable.fromArray(getDummyListForces()));
        mainActivity.launchActivity(null);
        onView(withId(R.id.search)).perform(click());
        onView(isAssignableFrom(EditText.class))
                .perform(typeText("lor"), pressKey(KeyEvent.KEYCODE_ENTER));
        onView(withRecyclerView(R.id.forces).onViewAtPosition(0, android.R.id.text1))
                .check(new TextViewTextAssertion("lorem"));
        onView(withRecyclerView(R.id.forces).onViewAtPosition(1, android.R.id.text1))
                .check(new TextViewTextAssertion("color"));
    }

    @Test
    public void testSearchCloseButton() {
        when(mBackendServiceApi.getAllForces())
                .thenReturn(Flowable.fromArray(getDummyListForces()));
        mainActivity.launchActivity(null);
        onView(withId(R.id.search)).perform(click());
        onView(isAssignableFrom(EditText.class))
                .perform(typeText("sit"), pressKey(KeyEvent.KEYCODE_ENTER));
        onView(withRecyclerView(R.id.forces).onViewAtPosition(0, android.R.id.text1))
                .check(new TextViewTextAssertion("sit"));
        onView(withId(android.support.v7.appcompat.R.id.search_close_btn)).perform(click());
        onView(isAssignableFrom(EditText.class)).check(new EmptyTextViewTextAssertion());
    }


    @Test
    public void testCloseSearch() {
        when(mBackendServiceApi.getAllForces())
                .thenReturn(Flowable.fromArray(getDummyListForces()));
        mainActivity.launchActivity(null);
        onView(withId(R.id.search)).perform(click());
        onView(isAssignableFrom(EditText.class))
                .perform(typeText("sit"), pressKey(KeyEvent.KEYCODE_ENTER));
        onView(withRecyclerView(R.id.forces).onViewAtPosition(0, android.R.id.text1))
                .check(new TextViewTextAssertion("sit"));
        onView(navigationIconMatcher()).perform(click());
        List<ForceItem> dummyForces = new ArrayList<>();
        for (int index = 0; index < dummyForces.size(); index++) {
            onView(withRecyclerView(R.id.forces).onViewAtPosition(index, android.R.id.text1))
                    .check(new TextViewTextAssertion(dummyForces.get(index).name()));
        }
    }

    @Test
    public void testOpenDrawer() {
        when(mBackendServiceApi.getAllForces())
                .thenReturn(Flowable.fromArray(getDummyListForces()));
        mainActivity.launchActivity(null);
        onView(withId(R.id.drawer_layout)).perform(open());
        onView(withId(R.id.drawer_layout)).check(ViewAssertions.matches((isDisplayed())));
    }
}
