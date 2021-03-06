/**
 *  @(#) CastEvaluator.java
 *
 * JReversePro - Java Decompiler / Disassembler.
 * Copyright (C) 2008 Karthik Kumar.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 *  
 *  	http://www.apache.org/licenses/LICENSE-2.0 
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 **/
package org.jreversepro.ast.evaluator;


import java.util.Arrays;

import org.jreversepro.ast.expression.UnaryOpExpression;
import org.jreversepro.ast.expression.UnaryOpExpression.UnaryOperator;
import org.jreversepro.reflect.instruction.Instruction;


/**
 * @author akkumar
 * 
 */
public class CastEvaluator extends AbstractInstructionEvaluator {

  /**
   * @param context
   */
  public CastEvaluator(EvaluatorContext context) {
    super(context);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * net.sf.jrevpro.decompile.evaluator.AbstractInstructionEvaluator#evaluate
   * (net.sf.jrevpro.reflect.instruction.Instruction)
   */
  @Override
  void evaluate(Instruction ins) {
    switch (ins.opcode) {
    case OPCODE_I2L:
    case OPCODE_F2L:
    case OPCODE_D2L:
      UnaryOpExpression.evaluateCasting(evalMachine, UnaryOperator.CAST_LONG);
      break;
    case OPCODE_I2F:
    case OPCODE_L2F:
    case OPCODE_D2F:
      UnaryOpExpression.evaluateCasting(evalMachine, UnaryOperator.CAST_FLOAT);
      break;
    case OPCODE_I2D:
    case OPCODE_L2D:
    case OPCODE_F2D:
      UnaryOpExpression.evaluateCasting(evalMachine, UnaryOperator.CAST_DOUBLE);
      break;
    case OPCODE_L2I:
    case OPCODE_F2I:
    case OPCODE_D2I:
      UnaryOpExpression.evaluateCasting(evalMachine, UnaryOperator.CAST_INT);
      break;
    case OPCODE_I2B:
      UnaryOpExpression.evaluateCasting(evalMachine, UnaryOperator.CAST_BYTE);
      break;
    case OPCODE_I2C:
      UnaryOpExpression.evaluateCasting(evalMachine, UnaryOperator.CAST_CHAR);
      break;
    case OPCODE_I2S:
      UnaryOpExpression.evaluateCasting(evalMachine, UnaryOperator.CAST_SHORT);
      break;

    }
  }

  /*
   * (non-Javadoc)
   * 
   * @seenet.sf.jrevpro.decompile.evaluator.AbstractInstructionEvaluator#
   * getProcessingOpcodes()
   */
  @Override
  Iterable<Integer> getProcessingOpcodes() {
    return Arrays.asList(OPCODE_I2L, OPCODE_F2L, OPCODE_D2L, // long
        OPCODE_I2F, OPCODE_L2F, OPCODE_D2F, // float
        OPCODE_I2D, OPCODE_L2D, OPCODE_F2D, // double
        OPCODE_L2I, OPCODE_F2I, OPCODE_D2I, // int
        OPCODE_I2B, OPCODE_I2C, OPCODE_I2S // integer to other types
    );
  }
}
