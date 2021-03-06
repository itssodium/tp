package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import seedu.address.commons.util.JsonUtil;
import seedu.address.model.task.TaskList;
import seedu.address.testutil.TypicalTasks;

class JsonSerializableTaskListTest {
    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableTaskListTest");
    private static final Path TYPICAL_TASk_LIST = TEST_DATA_FOLDER.resolve("typicalTasksInTaskList.json");

    @Test
    public void toModelType_typicalRoomFile_success() throws Exception {
        JsonSerializableTaskList dataFromFile = JsonUtil.readJsonFile(TYPICAL_TASk_LIST,
                JsonSerializableTaskList.class).get();
        TaskList covigentAppFromFile = dataFromFile.toModelType();
        TaskList typicalRoomList = TypicalTasks.getTypicalTaskList();
        assertEquals(covigentAppFromFile, typicalRoomList);
    }
}
