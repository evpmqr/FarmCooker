package com.script;

import com.frc.frc_api2.node_framework.my_nodes.BaseNode;
import com.frc.frc_api2.script_paint.PaintManager;
import com.frc.frc_api2.script_paint.my_paints.PaintLine;
import com.frc.frc_api2.script_paint.my_paints.SkillProgressBar;
import com.script.area.HouseArea;
import com.script.nodes.ClickContinue;
import com.script.nodes.HandleRun;
import com.script.parents.CookingTasks;
import org.tbot.bot.TBot;
import org.tbot.internal.Manifest;
import org.tbot.internal.ScriptCategory;
import org.tbot.methods.Skills;

/**
 * Created by Eric Vue on 7/31/2016.
 */
@Manifest(version = .01, name = "FarmCooker", description = "", category = ScriptCategory.MINIGAMES, openSource = false, authors = "Horror")
public class Script extends FrcScript {
    @Override
    public void initNodes(BaseNode nodeTree) {
        startLoop();
        nodeTree.add(new ClickContinue(), new HandleRun(), new CookingTasks());
    }
    @Override
    public void initListeners(){
        TBot.getBot().getDefaultWeb().getData().add(new HouseArea());

        PaintManager.getFrame().drawStatus(false).setLocation(0,0);
        PaintManager.getFrame().getScriptPanel().addLine(new PaintLine() {
            @Override
            public String getLine() {
                return getNodeTree().getStatus();
            }
        });
        PaintManager.getFrame().getScriptPanel().addLine(new PaintLine() {
            @Override
            public String getLine() {
                return ""+ Skills.getCurrentLevel(Skills.Skill.COOKING);
            }
        });
        PaintManager.getFrame().getScriptPanel().addLine(new SkillProgressBar(Skills.Skill.COOKING));
    }
}
